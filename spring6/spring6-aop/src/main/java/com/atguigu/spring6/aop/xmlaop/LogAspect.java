package com.atguigu.spring6.aop.xmlaop;
/*
 * @author  AmbitionJingH
 * @date  2023/8/19 15:07
 * @version 1.0
 */


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//切面类
@Aspect//切面类
@Component//ioc容器
public class LogAspect {
    //设置切入点和通知类型
    //通知类型：
    // 前置
    public void beforeMethod(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger-->前置通知，参数："+ Arrays.toString(args));
    }
    // 返回
    public void afterReturningMethod(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->返回通知，方法名："+methodName+"，结果："+result);
    }
    // 异常
    //目标方法出现了异常，这个通知执行
    public void afterThrowingMethod(JoinPoint joinPoint,Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->异常通知，方法名："+methodName+"，异常："+ex);
    }
    // 后置
    public void afterMethod(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println("Logger-->后置通知，方法名："+name);
    }
    // 环绕
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argString = Arrays.toString(args);
        Object result = null;
        try {
            System.out.println("环绕通知==目标方法之前执行");
            //调用目标方法
            result = joinPoint.proceed();
            System.out.println("环绕通知==目标方法返回值之后执行");
        }catch (Throwable throwable){
            throwable.printStackTrace();
            System.out.println("环绕通知==目标方法出现异常执行");
        }finally {
            System.out.println("环绕通知==目标方法执行完毕执行");
        }
        return result;
    }

    //重用切入点表达式
    public void pointcut(){}



}
