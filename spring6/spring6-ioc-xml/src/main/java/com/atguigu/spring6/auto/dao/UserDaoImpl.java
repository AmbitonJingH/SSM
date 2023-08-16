package com.atguigu.spring6.auto.dao;
/*
 * @author  AmbitionJingH
 * @date  2023/8/16 19:43
 * @version 1.0
 */

public class UserDaoImpl implements UserDao{
    @Override
    public void addUser() {
        System.out.println("userDao.addUser()");
    }
}
