package com.atguigu.spring6.scope;
/*
 * @author  AmbitionJingH
 * @date  2023/8/16 18:39
 * @version 1.0
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrder {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");
        Order order = context.getBean("order", Order.class);
        System.out.println(order);
        Order order1 = context.getBean("order", Order.class);
        System.out.println(order1);
    }
}
