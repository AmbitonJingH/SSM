package com.atguigu.spring6.springI18n;
/*
 * @author  AmbitionJingH
 * @date  2023/8/20 23:53
 * @version 1.0
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

public class ResourceI18n {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Object[] objects = new Object[]{"atguigu",new Date().toString()};
        String value = context.getMessage("www.atguigu.com", objects, Locale.CHINA);
        String value1 = context.getMessage("www.atguigu.com", objects, Locale.UK);
        System.out.println(value);
        System.out.println(value1);
    }
}
