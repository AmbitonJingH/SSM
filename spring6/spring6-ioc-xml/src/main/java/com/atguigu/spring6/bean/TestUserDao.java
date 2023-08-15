package com.atguigu.spring6.bean;
/*
 * @author  AmbitionJingH
 * @date  2023/8/15 19:39
 * @version 1.0
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println("userDao = " + userDao);
        userDao.run();

    }
}
