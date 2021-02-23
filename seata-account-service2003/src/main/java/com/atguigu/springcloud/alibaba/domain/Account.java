package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author LiHui
 * @create 2021--02--21--18:19
 * @date 2021/2/21--18:19
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Account {
    private  Long id;
    private Long userId;
    private BigDecimal total;//总额度
    private BigDecimal used;//已用额度；
    private BigDecimal residue;//剩余额度
}
