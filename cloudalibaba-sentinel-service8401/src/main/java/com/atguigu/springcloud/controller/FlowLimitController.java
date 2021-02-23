package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author LiHui
 * @create 2021--02--19--15:28
 * @date 2021/2/19--15:28
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        log.info(Thread.currentThread().getName()+"\t"+"...testA");
        return "-----------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "--------testB";
    }
    @GetMapping("/testD")
    public String testD(){
        //暂停1秒钟线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i=1/0;
        log.info("test  测试RT");
        return "---------testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")   //处理Sentinel控制台配置的违规情况。
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "--------testHotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "-----------deal_testHotKey,o(╥﹏╥)o";
    }
}
