package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author LiHui
 * @create 2021--01--13--15:29
 * @date 2021/1/13--15:29
 */
@Service
public class PaymentService {
    public String paymentInfo_OK( Integer id){
        return "线程池：   "+Thread.currentThread().getName()+"   paymentInfo_OK,id   "+id+"\t哈哈";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
            /*规定这个线程响应时间的最大值是3秒，超过3秒，认为出错，启用服务降级后的方法*/
    })
    public String paymentInfo_TimeOut( Integer id){
       // int timeNumber=5;
        int mTimeNumber=3000;
        //int i=10/0;
        try {
          //  TimeUnit.SECONDS.sleep(timeNumber);   单位是秒
            TimeUnit.MILLISECONDS.sleep(mTimeNumber);//单位是毫秒
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池：   "+Thread.currentThread().getName()+"   paymentInfo_TimeOut,id   "+id+"\t☺";
    }
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池：   "+Thread.currentThread().getName()+"   8001系统出错，请稍后再试,id   "+id+"\to(╥﹏╥)o";
    }

    /*--------服务熔断*/


    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "3"),//请求次数   请求总数阈值，默认20
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间范围   快照时间窗    默认最近10秒
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸。错误百分比阈值  默认50%
            //上述意思是，在10秒内，10次请求中，失败率达到60%，即6次及以上，跳闸。然后所有请求都不会转发
            //一段时间以后（默认5秒），断路器回到半开状态。
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){//这一层的@PathVariable，可写可不写
        if (id<0){
            throw new RuntimeException("***id  不能是负数");
        }
        String serialNumber = IdUtil.simpleUUID();//在commons模块中引入了hutool工具包坐标//==UUID.randomUUID().toString()
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }

    public  String paymentCircuitBreaker_fallback( Integer id){
        return "id  不能为负数，请稍后再试，o(╥﹏╥)o，id"+id;
    }
}
