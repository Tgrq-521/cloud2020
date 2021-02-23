package com.atguigu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @author LiHui
 * @create 2021--02--20--10:48
 * @date 2021/2/20--10:48
 */
public class CustomerBlockHandler {
    public static com.atguigu.springcloud.entities.CommonResult handlerException1(BlockException exception){
        return  new CommonResult(4444,"global---1");
    }
    public static com.atguigu.springcloud.entities.CommonResult handlerException2(BlockException exception){
        return  new CommonResult(4444,"global---2");
    }
}
