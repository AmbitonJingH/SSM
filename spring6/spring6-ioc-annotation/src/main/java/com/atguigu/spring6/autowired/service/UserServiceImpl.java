package com.atguigu.spring6.autowired.service;

import com.atguigu.spring6.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
 * @author  AmbitionJingH
 * @date  2023/8/17 19:19
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService{
    //第一种方式 属性注入
//    @Autowired
//    private UserDao userDao;

    //第二种方式 set方法注入
    //private UserDao userDao;
//    @Autowired
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    //第三种方式 构造方法注入
//    private UserDao userDao;
//    @Autowired
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

    //第四种方式 形参上注入
//    private UserDao userDao;
//    public UserServiceImpl(@Autowired UserDao userDao) {
//        this.userDao = userDao;
//    }

    //第五种方式 只有一个有参数构造方法，无注解

    private UserDao userDao;

    public UserServiceImpl(@Qualifier(value = "userRedisDaoImpl") UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("userService.add()...");
        userDao.add();
    }
}
