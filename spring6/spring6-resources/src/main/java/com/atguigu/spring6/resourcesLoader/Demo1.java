package com.atguigu.spring6.resourcesLoader;
/*
 * @author  AmbitionJingH
 * @date  2023/8/20 23:13
 * @version 1.0
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

public class Demo1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext();
        Resource resource = context.getResource("atguigu.txt");
        System.out.println(resource.getFilename());

        ApplicationContext context1 = new FileSystemXmlApplicationContext();
        Resource resource1 = context1.getResource("atguigu.txt");
        System.out.println(resource1.getFilename());
    }
}
