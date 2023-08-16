package com.atguigu.spring6.auto.service;
/*
 * @author  AmbitionJingH
 * @date  2023/8/16 19:43
 * @version 1.0
 */

import com.atguigu.spring6.auto.dao.UserDao;
import com.atguigu.spring6.auto.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
    private UserDao userDao = new UserDaoImpl();

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser() {
        System.out.println("userService.addUser()");
        userDao.addUser();
    }
}
