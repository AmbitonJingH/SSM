package com.atguigu.spring6.diTest;
/*
 * @author  AmbitionJingH
 * @date  2023/8/16 9:36
 * @version 1.0
 */


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-dilist.xml");
        Dept dept = context.getBean("dept", Dept.class);
//        Emp emp = context.getBean("emp", Emp.class);
//        emp.work();
        dept.info();
    }
}
