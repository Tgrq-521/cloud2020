package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author LiHui
 * @create 2021--02--21--17:37
 * @date 2021/2/21--17:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Storage {
    private Long id;
    private Long productId;
    private Integer total;//总库存
    private Integer used;//已用库存
    private  Integer residue;//剩余库存

}
