package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LiHui
 * @create 2021--01--12--18:10
 * @date 2021/1/12--18:10
 */
@SpringBootApplication
@EnableFeignClients/*使用feign，激活并开启*/
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}
