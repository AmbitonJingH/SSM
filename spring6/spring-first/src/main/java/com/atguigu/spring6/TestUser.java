package com.atguigu.spring6;
/*
 * @author  AmbitionJingH
 * @date  2023/8/15 18:17
 * @version 1.0
 */


import org.slf4j.Logger;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class TestUser {
    //创建Logger对象
    private Logger logger  = LoggerFactory.getLogger(TestUser.class);
    @Test
    public void test(){
        //加载spring配置文件，进行对象创建
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //获取创建的对象
        User user = (User) context.getBean("user");
        System.out.println(user);
        //调用对象的方法进行测试
        user.add();
        //手动写日志
        logger.info("执行调用成功了");
    }
    @Test
    public void test1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //反射创建对象
        Class clazz = Class.forName("com.atguigu.spring6.User");
        User user = (User) clazz.getDeclaredConstructor().newInstance();
        System.out.println(user);
    }
}
