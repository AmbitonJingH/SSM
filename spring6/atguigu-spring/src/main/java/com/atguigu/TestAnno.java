package com.atguigu;
/*
 * @author  AmbitionJingH
 * @date  2023/8/19 11:15
 * @version 1.0
 */

import com.atguigu.bean.AnnotationApplicationContext;
import com.atguigu.bean.ApplicationContext;
import com.atguigu.service.UserService;

public class TestAnno {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationApplicationContext("com.atguigu");
        UserService userService =(UserService) context.getBean(UserService.class);
        System.out.println("userService = " + userService);
        userService.run();
    }
}
