package com.atguigu.boot;
/*
 * @author  AmbitionJingH
 * @date  2023/9/16 15:28
 * @version 1.0
 *
 * 启动springboot项目的主入口程序
 */

import com.atguigu.boot.Bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication  //这是一个SpringBoot应用
public class MainApplication {
    public static void main(String[] args) {
        var ioc = SpringApplication.run(MainApplication.class, args);
        //获取容器中所有组件的名字
//        String[] names = ioc.getBeanDefinitionNames();
//        for(String name : names){
//            System.out.println(name);
//        }
        String[] forType = ioc.getBeanNamesForType(User.class);
        for (String s : forType) {
            System.out.println(s);
        }
        Object user1 = ioc.getBean("user");
        Object user2 = ioc.getBean("user");
        System.out.println(user1 == user2);
    }
}
