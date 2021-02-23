package com.atguigu.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author LiHui
 * @create 2021--02--21--18:29
 * @date 2021/2/21--18:29
 */
public interface AccountService {
    void decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money);
}
