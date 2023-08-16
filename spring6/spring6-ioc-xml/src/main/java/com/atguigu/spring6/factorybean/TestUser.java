package com.atguigu.spring6.factorybean;
/*
 * @author  AmbitionJingH
 * @date  2023/8/16 19:27
 * @version 1.0
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-factorybean.xml");
        User user = (User) context.getBean("user");
        System.out.println(user);
    }
}
