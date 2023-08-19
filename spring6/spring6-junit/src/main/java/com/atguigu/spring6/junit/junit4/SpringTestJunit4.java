package com.atguigu.spring6.junit.junit4;
/*
 * @author  AmbitionJingH
 * @date  2023/8/19 16:24
 * @version 1.0
 */

import com.atguigu.spring6.junit.junit5.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class SpringTestJunit4 {
    @Autowired
    private User user;
    @Test
    public void test(){
        System.out.println("user = " + user);
        user.run();
    }
}
