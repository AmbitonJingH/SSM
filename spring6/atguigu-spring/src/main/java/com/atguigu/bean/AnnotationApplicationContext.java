package com.atguigu.bean;
/*
 * @author  AmbitionJingH
 * @date  2023/8/19 10:05
 * @version 1.0
 */

import com.atguigu.anno.Bean;
import com.atguigu.anno.Di;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationApplicationContext implements ApplicationContext{
    //创建map集合放bean对象
    private Map<Class,Object> beanFactory = new HashMap<>();
    private String rootPath;
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    //创建有参数构造。传递包路径，设置包扫描规则
    public AnnotationApplicationContext(String basePackage) {
        try {
            //com.atguigu
            //1. 把.替换成\
            String packagePath =  basePackage.replaceAll("\\.","\\\\");
            //2. 获取包的绝对路径
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                rootPath = filePath.substring(0,filePath.length()-packagePath.length());
                //包扫描
                loadBean(new File(filePath));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //属性注入
        loadDi();
    }


    private void loadBean(File file) throws Exception{
        //1. 判断读取是不是文件夹
        if (file.isDirectory()){
            //2. 获取文件夹里的所有内容
            File[] childFiles = file.listFiles();

            //3. 判断文件里为空直接返回
            if(childFiles==null || childFiles.length==0)
                return;
            //4. 如果文件夹不为空 遍历
            for(File file1 : childFiles){
                //4.1 遍历得到每个File对象，继续判断，如果还是文件夹，递归
                if(file1.isDirectory()){
                    loadBean(file1);
                }else {
                    //4.2 遍历得到File对象不是文件夹是文件
                    //4.3 的到包路径+类名称部分-字符串截取
                    String pathWithClass = file1.getAbsolutePath().substring(rootPath.length() - 1);
                    //4.4判断当前文件类型是否.class
                    if(pathWithClass.contains(".class")){
                        //4.5如果是.class类型，把路径\替换成.把.class去掉
                        String allName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");
                        //com.atguigu.service.UserServiceImpl
                        //4.6判断类上面是否有注解@Bean,如果有进行实例化
                        //4.6.1获取类的class对象
                        Class<?> clazz = Class.forName(allName);
                        //4.6.2判断不是接口
                        if(!clazz.isInterface()){
                            //4.6.3判断是否有注解
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if(annotation!=null){
                                //4.6.4 实例化
                                Object instance = clazz.getDeclaredConstructor().newInstance();
                                //4.7把对象实例化后 放入map集合beanFactory
                                //4.7.1如果当前类有接口让接口class作为map的key
                                if(clazz.getInterfaces().length>0){
                                    beanFactory.put(clazz.getInterfaces()[0],instance);
                                }else {
                                    beanFactory.put(clazz,instance);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    //属性注入
    private void loadDi() {
        //实例化对象在beanFactory的map集合里
        //1.遍历beanFactory的map集合
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for(Map.Entry<Class, Object> entry : entries){
            //2.获取map集合每个对象（value），获取到每个对象属性
            Object obj = entry.getValue();
            //获取对象Class
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            //3.遍历属性数组，得到每个属性
            for(Field filed:fields){
                //4.判断属性上是否有@Di注解
                Di annotation = filed.getAnnotation(Di.class);
                if(annotation!=null){
                    //5.如果有，把对象进行注入
                    filed.setAccessible(true);
                    try {
                        filed.set(obj,beanFactory.get(filed.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }




    }






}
