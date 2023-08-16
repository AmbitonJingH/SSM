package com.atguigu.spring6.life;
/*
 * @author  AmbitionJingH
 * @date  2023/8/16 19:05
 * @version 1.0
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-life.xml");
        User user = context.getBean("user", User.class);
        System.out.println("6. 对象创建完成 可以使用");
        System.out.println(user);
        context.close();//销毁
    }
}
