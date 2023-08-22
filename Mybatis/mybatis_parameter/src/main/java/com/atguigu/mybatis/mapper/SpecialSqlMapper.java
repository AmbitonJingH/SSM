package com.atguigu.mybatis.mapper;
/*
 * @author  AmbitionJingH
 * @date  2023/8/22 23:09
 * @version 1.0
 */

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSqlMapper {
    List<User> getUserByLike(@Param("mohu") String mohu);
    void deleteMoreUser(@Param("ids") String ids);
}
