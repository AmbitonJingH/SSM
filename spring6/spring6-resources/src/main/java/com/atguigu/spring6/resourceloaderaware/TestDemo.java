package com.atguigu.spring6.resourceloaderaware;
/*
 * @author  AmbitionJingH
 * @date  2023/8/20 23:21
 * @version 1.0
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

public class TestDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        TestBean bean = context.getBean("testBean", TestBean.class);
        ResourceLoader resourceLoader = bean.getResourceLoader();
        System.out.println(context == resourceLoader);
    }
}
