package com.atguigu.spring6.aop.example;
/*
 * @author  AmbitionJingH
 * @date  2023/8/19 12:13
 * @version 1.0
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    //目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //返回代理对象
    public Object getProxy(){
        /*
        * Proxy.newProxyInstance();有三个参数
        * 1.ClassLoader:加载动态生成代理类的类加载器
        * 2.Class<?> [] interfaces:目标对象实现的所有接口的class类型数组
        * 3.InvocationHandler:设置代理对象实现目标对象方法的过程
        * */

        //1.ClassLoader:加载动态生成代理类的类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();
        //2.Class<?> [] interfaces:目标对象实现的所有接口的class类型数组
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //3.InvocationHandler:设置代理对象实现目标对象方法的过程
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                //Object o: 代理对象
                //Method method:需要重写目标对象的方法
                //Object[] objects:method方法里的参数
                System.out.println("[动态代理][日志] "+method.getName()+"，参数："+ Arrays.toString(objects));
                Object result = method.invoke(target, objects);
                System.out.println("[动态代理][日志] "+method.getName()+"，结果："+ result);
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,handler);
    }
}
