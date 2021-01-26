package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author LiHui
 * @create 2021--01--08--18:25
 * @date 2021/1/8--18:25
 */
@SpringBootApplication
@EnableEurekaClient
/*@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)引入自定义的ribbon规则*/
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
