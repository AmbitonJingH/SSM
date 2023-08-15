package com.atguigu.spring6;
/*
 * @author  AmbitionJingH
 * @date  2023/8/15 19:12
 * @version 1.0
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User) context.getBean("user");
        System.out.println("根据id获取:"+user);

        User user1 = context.getBean(User.class);
        System.out.println("根据类型获取:"+user1);

        User user2 = context.getBean("user", User.class);
        System.out.println("根据id和类型获取:"+user2);
    }
}
