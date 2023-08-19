package com.atguigu.spring6.aop.xmlaop;
/*
 * @author  AmbitionJingH
 * @date  2023/8/19 15:21
 * @version 1.0
 */

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-aop.xml");
        Calculator calculator = context.getBean(Calculator.class);
        //calculator.add(15,22);
        calculator.div(115,10);
    }
}
