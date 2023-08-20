package com.atguigu.spring6.prefix;
/*
 * @author  AmbitionJingH
 * @date  2023/8/20 23:33
 * @version 1.0
 */

import com.atguigu.spring6.di.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class TestDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean*.xml");
//        Resource resource = context.getResource("atguigu.txt");
//        System.out.println(resource.getDescription());
        User user = context.getBean(User.class);
        System.out.println(user);
    }
}
