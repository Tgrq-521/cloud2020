package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LiHui
 * @create 2021--02--20--11:48
 * @date 2021/2/20--11:48
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients   //使用feign，激活并开启
public class MainOrder84 {
    public static void main(String[] args) {
        SpringApplication.run(MainOrder84.class,args);
    }
}
