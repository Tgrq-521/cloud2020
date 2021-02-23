package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.OrderDao;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.AccountService;
import com.atguigu.springcloud.alibaba.service.OrderService;
import com.atguigu.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LiHui
 * @create 2021--02--21--11:32
 * @date 2021/2/21--11:32
 */
@Service
@Slf4j

public class OrderServiceImpl  implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    //name随便写，这里的意思是，不管发生什么异常，都回滚。
    public void create(Order order) {

        log.info("--------开始新建订单");
        orderDao.create(order);

        log.info("-------订单微服务开始调库存，做扣减count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("-------订单微服务开始调库存，扣减结束");

        log.info("-------订单微服务开始调账户，做扣减money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("-------订单微服务开始调账户，扣减结束");

        log.info("--------修改订单状态");
        orderDao.update(order.getUserId(),0);
        log.info("--------修改订单状态结束");
        log.info("--------订单完成了");


    }
}
