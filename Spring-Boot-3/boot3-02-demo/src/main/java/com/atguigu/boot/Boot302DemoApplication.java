package com.atguigu.boot;

import com.atguigu.boot.Bean.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot302DemoApplication {

    public static void main(String[] args) {
        var ioc = SpringApplication.run(Boot302DemoApplication.class, args);
        String[] forType = ioc.getBeanNamesForType(Cat.class);
        for (String s : forType) {
            System.out.println("Cat = " + s);
        }

        String[] forType2 = ioc.getBeanNamesForType(Dog.class);
        for (String s : forType2) {
            System.out.println("Dog = " + s);
        }

        String[] forType3 = ioc.getBeanNamesForType(User.class);
        for (String s : forType3) {
            System.out.println("User = " + s);
        }

        Pig pig = ioc.getBean(Pig.class);
        System.out.println(pig);

        Sheep sheep = ioc.getBean(Sheep.class);
        System.out.println(sheep);
    }

}
