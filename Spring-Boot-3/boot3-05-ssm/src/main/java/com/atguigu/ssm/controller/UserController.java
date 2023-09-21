package com.atguigu.ssm.controller;
/*
 * @author  AmbitionJingH
 * @date  2023/9/21 23:50
 * @version 1.0
 */

import com.atguigu.ssm.bean.TUser;
import com.atguigu.ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.PanelUI;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/user/{id}")
    public TUser getUserById(@PathVariable("id") Long id){
        TUser user = userMapper.getUserById(id);
        return user;//返回user的json数据
    }

}
