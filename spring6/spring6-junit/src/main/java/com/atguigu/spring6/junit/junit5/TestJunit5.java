package com.atguigu.spring6.junit.junit5;
/*
 * @author  AmbitionJingH
 * @date  2023/8/19 16:14
 * @version 1.0
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean.xml")
@SpringJUnitConfig(locations = "classpath:bean.xml")
public class TestJunit5 {
    //注入
    @Autowired
    private User user;
    //测试方法
    @Test
    public void test(){
        System.out.println(user);
        user.run();
    }
}
