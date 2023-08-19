package com.atguigu.dao.impl;
/*
 * @author  AmbitionJingH
 * @date  2023/8/19 10:01
 * @version 1.0
 */

import com.atguigu.anno.Bean;
import com.atguigu.dao.UserDao;
@Bean
public class UserDaoImpl implements UserDao {
    public void run(){
        System.out.println("dao...");
    }
}
