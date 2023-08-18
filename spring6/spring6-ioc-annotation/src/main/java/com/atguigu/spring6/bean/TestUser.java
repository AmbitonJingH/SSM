package com.atguigu.spring6.bean;
/*
 * @author  AmbitionJingH
 * @date  2023/8/17 19:09
 * @version 1.0
 */

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User bean = context.getBean(User.class);
        System.out.println(bean);
    }
}
