package com.atguigu.spring6.resource.controller;

import com.atguigu.spring6.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

/*
 * @author  AmbitionJingH
 * @date  2023/8/17 19:19
 * @version 1.0
 */
@Controller("myUserController")
public class UserController {

    //根据名称注入
    @Resource(name = "myUserService")
    private UserService userService;
    public void add(){
        System.out.println("userController.add()");
        userService.add();

    }
}
