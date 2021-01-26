package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author LiHui
 * @create 2021--01--08--15:37
 * @date 2021/1/8--15:37
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById( Long id);
}
