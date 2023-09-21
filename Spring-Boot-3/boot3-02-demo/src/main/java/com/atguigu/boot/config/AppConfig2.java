package com.atguigu.boot.config;
/*
 * @author  AmbitionJingH
 * @date  2023/9/17 11:21
 * @version 1.0
 */

import com.alibaba.druid.FastsqlException;
import com.atguigu.boot.Bean.*;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
/*
* 1、开启Sheep组件的属性绑定
* 2、默认会把这个组件放到容器中
* */
@EnableConfigurationProperties(Sheep.class)
@ConditionalOnClass(name = "com.alibaba.druid.FastsqlException")//放在类级别，如果注解判断生效，则整个配置类才生效
@SpringBootConfiguration
public class AppConfig2 {

    @Bean
    @ConfigurationProperties(prefix = "pig")
    public Pig pig(){
        return new Pig();
    }
    @ConditionalOnClass(name="com.alibaba.druid.FastsqlException")//放在方法级别，单独对这个方法进行注解判断
    @Bean
    public Cat cat01(){
        return new Cat();
    }

    @ConditionalOnMissingClass("com.alibaba.druid.FastsqlException")
    @Bean
    public Dog dog01(){
        return new Dog();
    }
    @ConditionalOnBean(Dog.class)
    @Bean
    public User zhangsan(){
        return new User();
    }

    @ConditionalOnMissingBean(Dog.class)
    @Bean
    public User lisi(){
        return new User();
    }
}
