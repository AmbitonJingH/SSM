package com.atguigu.spring6.config;
/*
 * @author  AmbitionJingH
 * @date  2023/8/18 15:30
 * @version 1.0
 */

import com.atguigu.spring6.resource.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfigAnno {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(springConfig.class);
        UserController controller = context.getBean(UserController.class);
        controller.add();
    }
}
