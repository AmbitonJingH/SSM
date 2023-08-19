package com.atguigu.service.impl;
/*
 * @author  AmbitionJingH
 * @date  2023/8/19 10:01
 * @version 1.0
 */

import com.atguigu.anno.Bean;
import com.atguigu.anno.Di;
import com.atguigu.dao.UserDao;
import com.atguigu.service.UserService;
@Bean
public class UserServiceImpl implements UserService {
    @Di
    private UserDao userDao;

    public void run(){
        System.out.println("service...");
        userDao.run();
    }
}
