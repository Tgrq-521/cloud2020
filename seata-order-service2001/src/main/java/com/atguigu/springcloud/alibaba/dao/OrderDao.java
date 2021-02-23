package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author LiHui
 * @create 2021--02--21--10:44
 * @date 2021/2/21--10:44
 */
@Mapper
public interface OrderDao {
    void create(Order order);
    void update(@Param("userId") Long userId,@Param("status") Integer status );
}
