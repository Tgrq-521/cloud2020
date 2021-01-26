package com.atguigu.springcloud.config;

import feign.Logger;
import feign.Logger.Level;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author LiHui
 * @create 2021--01--12--22:21
 * @date 2021/1/12--22:21
 */
@Component
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
