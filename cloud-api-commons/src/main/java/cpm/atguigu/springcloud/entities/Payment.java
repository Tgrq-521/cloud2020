package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author LiHui
 * @create 2021--01--08--18:29
 * @date 2021/1/8--18:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable/*序列化，分布式部署，可能会用的到*/ {
    private Long id;
    private String serial;
}
