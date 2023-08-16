package com.atguigu.spring6.factorybean;
/*
 * @author  AmbitionJingH
 * @date  2023/8/16 19:25
 * @version 1.0
 */

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
