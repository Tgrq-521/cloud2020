package com.atguigu.springcloud.alibaba.service;

/**
 * @author LiHui
 * @create 2021--02--21--17:59
 * @date 2021/2/21--17:59
 */
public interface StorageService {
    void decrease(Long productId,Integer count);
}
