package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author LiHui
 * @create 2021--02--21--17:45
 * @date 2021/2/21--17:45
 */
@Mapper
public interface StorageDao {
    void decrease(@Param("productId") Long productId,@Param("count") Integer count);
}
