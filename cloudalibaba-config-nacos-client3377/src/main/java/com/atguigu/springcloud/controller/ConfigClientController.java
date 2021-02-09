package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiHui
 * @create 2021--02--04--18:04
 * @date 2021/2/4--18:04
 */
@RestController
@RefreshScope//支持nacos的动态刷新
public class ConfigClientController {
    @Value("${config.info}")
    private  String configInfo;
    @GetMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }
}
