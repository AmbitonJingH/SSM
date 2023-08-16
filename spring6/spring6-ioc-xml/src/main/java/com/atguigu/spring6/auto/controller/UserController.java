package com.atguigu.spring6.auto.controller;
/*
 * @author  AmbitionJingH
 * @date  2023/8/16 19:42
 * @version 1.0
 */

import com.atguigu.spring6.auto.service.UserService;
import com.atguigu.spring6.auto.service.UserServiceImpl;

public class UserController {
    private UserService userService = new UserServiceImpl();

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("userController.addUser()");
        userService.addUser();
    }
}
