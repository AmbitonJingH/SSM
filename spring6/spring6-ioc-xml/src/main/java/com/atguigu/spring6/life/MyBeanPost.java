package com.atguigu.spring6.life;
/*
 * @author  AmbitionJingH
 * @date  2023/8/16 19:10
 * @version 1.0
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

public class MyBeanPost implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("3.  bean后置处理器 在初始化之前执行");
        System.out.println(beanName+"::"+bean);
        return bean;
    }


    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("5.  bean后置处理器 在初始化之后执行");
        System.out.println(beanName+"::"+bean);
        return bean;
    }

}
