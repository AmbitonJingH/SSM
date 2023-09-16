package com.atguigu.boot.config;
/*
 * @author  AmbitionJingH
 * @date  2023/9/17 0:13
 * @version 1.0
 */

import com.alibaba.druid.FastsqlException;
import com.atguigu.boot.Bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Import(FastsqlException.class)//可以通过import进行导入 在ioc容器中的名字默认为全类名
@Configuration //这是一个配置类，替代以前的配置文件
public class AppConfig {

    @Scope("prototype")
    @Bean //代替以前的bean标签。组件在容器中的名字默认是方法名 可以通过直接修改注解的值进行修改
    public User user(){
        var user = new User();
        user.setId(1l);
        user.setName("黄浩");
        return user;
    }
}
