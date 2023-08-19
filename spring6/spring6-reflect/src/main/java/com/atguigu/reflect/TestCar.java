package com.atguigu.reflect;
/*
 * @author  AmbitionJingH
 * @date  2023/8/18 15:45
 * @version 1.0
 */

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCar {
    //1.获取Class对象多种方式
    @Test
    public void test() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //1 类名.Class
        Class carClass1 = Car.class;
        //2 对象.getClass()
        Class carClass2 = new Car().getClass();
        //3 Class.forName("全路径")
        Class carClass3 = Class.forName("com.atguigu.reflect.Car");
        //实例化
        Car car = (Car) carClass1.getDeclaredConstructor().newInstance();
        System.out.println("car = " + car);
    }
    //获取构造方法
    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class carClass = Car.class;
        //获取所有构造
        //carClass.getConstructors();获取public的构造方法
        //carClass.getDeclaredConstructors();获取所有构造方法
        Constructor[] constructors = carClass.getDeclaredConstructors();

        for(Constructor constructor : constructors){
            System.out.println("构造方法名称："+constructor.getName()+" 参数个数："+constructor.getParameterCount());
        }
        //构造public
//        Constructor c1 = carClass.getConstructor(String.class, int.class, String.class);
//        Car car1 = (Car) c1.newInstance("benz", 1, "红");
//        System.out.println("car1 = " + car1);
        //构造private
        Constructor c2 = carClass.getDeclaredConstructor(String.class, int.class, String.class);
        c2.setAccessible(true);
        c2.newInstance("马自达",10,"黑色");
        System.out.println("c2 = " + c2);
    }

    //获取属性
    @Test
    public void test2() throws Exception{
        Class carClass = Car.class;
        Car car =(Car) carClass.getDeclaredConstructor().newInstance();
        //carClass.getDeclaredFields();获取所有属性
        Field[] fields = carClass.getDeclaredFields();
        for(Field field : fields){
            if(field.getName().equals("name")){
                field.setAccessible(true);
                field.set(car,"golf5");
            }
            System.out.println(field.getName());

        }
        System.out.println(car);
    }

    //获取方法
    @Test
    public void test3() throws Exception{
        Class<Car> carClass = Car.class;
        Car car = carClass.getDeclaredConstructor().newInstance();
        //public方法
        Method[] methods1 = carClass.getMethods();
        for(Method method : methods1){
            System.out.println(method.getName());
            if(method.getName().equals("toString")) {
                String invoke = (String) method.invoke(car);
                System.out.println(invoke);
            }
        }
        System.out.println("---------");
        //carClass.getDeclaredMethods();获取所有方法（包含private）
        Method[] methods = carClass.getDeclaredMethods();
        for(Method method : methods){
            if(method.getName().equals("run")){
                method.setAccessible(true);
                method.invoke(car);
            }
            System.out.println(method.getName());
        }
    }

}
