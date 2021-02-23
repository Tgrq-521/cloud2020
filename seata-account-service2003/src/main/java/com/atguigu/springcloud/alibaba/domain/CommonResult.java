package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author LiHui
 * @create 2021--02--21--18:21
 * @date 2021/2/21--18:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T      data;
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
