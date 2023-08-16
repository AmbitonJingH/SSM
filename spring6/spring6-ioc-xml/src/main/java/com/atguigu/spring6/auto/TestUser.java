package com.atguigu.spring6.auto;
/*
 * @author  AmbitionJingH
 * @date  2023/8/16 20:04
 * @version 1.0
 */

import com.atguigu.spring6.auto.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-auto.xml");
        UserController userController = context.getBean("userController", UserController.class);
        userController.addUser();
    }
}
