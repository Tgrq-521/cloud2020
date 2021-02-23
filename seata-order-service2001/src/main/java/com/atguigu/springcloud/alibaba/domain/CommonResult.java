package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author LiHui
 * @create 2021--02--21--10:30
 * @date 2021/2/21--10:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommonResult<T> {
    private  Integer code;
    private  String message;
    private  T      data;
    public  CommonResult(Integer code,String message){
        this(code,message,null);
    }

}
