package com.atguigu.spring6.aop.example;
/*
 * @author  AmbitionJingH
 * @date  2023/8/19 12:25
 * @version 1.0
 */

public class TestCal {
    public static void main(String[] args) {
        //创建代理对象
        ProxyFactory factory = new ProxyFactory(new CalculatorImpl());
        Calculator cal = (Calculator) factory.getProxy();
        cal.add(10,11);
        cal.mul(55,10);
    }
}
