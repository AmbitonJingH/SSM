package com.atguigu.mybatis.mapper;
/*
 * @author  AmbitionJingH
 * @date  2023/8/22 19:17
 * @version 1.0
 */

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    User getUserById(@Param("id") Integer id);
    List<User> getAllUser();
    int getCount();
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);
    @MapKey("id")
    Map<String,Object> getAllUserToMap();
    List<Map<String,Object>> getAllUserToMap1();

}
