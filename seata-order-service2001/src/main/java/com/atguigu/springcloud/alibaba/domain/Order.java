package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author LiHui
 * @create 2021--02--21--10:30
 * @date 2021/2/21--10:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;//数量
    private BigDecimal money;
    private Integer status;//订单状态：0，创建中；1，已完结。
}
