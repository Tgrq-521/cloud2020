package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author LiHui
 * @create 2021--02--20--11:34
 * @date 2021/2/20--11:34
 */
@RestController
public class PaymentController {
    public static HashMap<Long, com.atguigu.springcloud.entities.Payment> hashMap = new HashMap<>();

    /**
     * 模拟数据库,为省事,不写数据库层面
     */
    static {
        hashMap.put(1L, new com.atguigu.springcloud.entities.Payment(1L, "28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put(2L, new com.atguigu.springcloud.entities.Payment(2L, "28a4c1e3bc2742d8848569891fb42181"));
        hashMap.put(3L, new com.atguigu.springcloud.entities.Payment(3L, "28a5c1e3bc2742d8848569891fb42181"));
    }

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/paymentSQL/{id}")
    public com.atguigu.springcloud.entities.CommonResult<com.atguigu.springcloud.entities.Payment> paymentSQL(@PathVariable("id") Long id) {
        com.atguigu.springcloud.entities.Payment payment = hashMap.get(id);
        com.atguigu.springcloud.entities.CommonResult<com.atguigu.springcloud.entities.Payment> result = new com.atguigu.springcloud.entities.CommonResult(200, "from mysql,serverPort: " + serverPort, payment);
        return result;
    }
}
