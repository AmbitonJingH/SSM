package com.atguigu.spring6.autowired.controller;

import com.atguigu.spring6.autowired.service.UserService;
import com.atguigu.spring6.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/*
 * @author  AmbitionJingH
 * @date  2023/8/17 19:19
 * @version 1.0
 */
@Controller
public class UserController {
    //第一种方式 属性注入
//    @Autowired
//    private UserService userService;

    //第二种方式 set方法注入
//    private UserService userService;
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    //第三种方式 构造方法注入
//    private UserService userService;
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    //第四种方式 形参上注入
//        private UserService userService;
//    public UserController(@Autowired UserService userService) {
//        this.userService = userService;
//    }

//第五种方式 只有一个有参数构造方法，无注解
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void add(){
        System.out.println("userController.add()");
        userService.add();

    }
}
