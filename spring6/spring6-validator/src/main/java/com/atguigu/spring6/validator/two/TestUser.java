package com.atguigu.spring6.validator.two;
/*
 * @author  AmbitionJingH
 * @date  2023/8/21 10:04
 * @version 1.0
 */

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {
    @Test
    public void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidatorConfig.class);
        MyValidation1 validation1 = context.getBean(MyValidation1.class);
        User user = new User();
        user.setName("lucy");
        user.setAge(20);
        boolean message = validation1.validatorByUser(user);
        System.out.println(message);
    }

    @Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidatorConfig.class);
        MyValidation2 validation2 = context.getBean(MyValidation2.class);
        User user = new User();
        user.setName("lucy");
        user.setAge(-20);
        boolean message = validation2.validatorByTwo(user);
        System.out.println(message);

    }
}
