package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author LiHui
 * @create 2021--02--20--15:03
 * @date 2021/2/20--15:03
 */
@Component
public class PaymentFallbackService implements  PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<Payment>(444,"服务降级返回---aymentFallbackService",new Payment(id,"error"));
    }
}
