package com.atguigu.spring6.aop.example;
/*
 * @author  AmbitionJingH
 * @date  2023/8/19 12:05
 * @version 1.0
 */

public class CalculatorStaticProxy implements Calculator{

    //被代理目标对象传递过来
    private Calculator calculator;

    public CalculatorStaticProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int i, int j) {
        //输出日志
        System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);
        // 通过目标对象来实现核心业务逻辑
        int addResult = calculator.add(i, j);
        System.out.println("[日志] add 方法结束了，结果是：" + addResult);
        return 0;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
