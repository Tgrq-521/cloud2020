package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author LiHui
 * @create 2021--01--13--22:48
 * @date 2021/1/13--22:48
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "------------PaymentFallbackService+++++paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------------PaymentFallbackService+++++paymentInfo_TimeOut";
    }
}
