package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author LiHui
 * @create 2021--01--07--22:38
 * @date 2021/1/7--22:38
 */
@Mapper
public interface PaymentDao {
    public int  create(Payment payment);  //or   add  or    save

    public Payment getPaymentById(@Param("id") Long id);
}
