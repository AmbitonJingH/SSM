package com.atguigu.mybatis.mapper;
/*
 * @author  AmbitionJingH
 * @date  2023/8/22 12:28
 * @version 1.0
 */

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    //添加用户信息
    int insertUser();
    //修改用户信息
    int updateUser();
    //删除用户信息
    int deleteUser();
    //根据id查询用户信息
    User getUserById();
    //查询所有用户信息
    List<User> getUserList();
}
