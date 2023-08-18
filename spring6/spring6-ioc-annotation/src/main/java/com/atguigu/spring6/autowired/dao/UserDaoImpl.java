package com.atguigu.spring6.autowired.dao;
/*
 * @author  AmbitionJingH
 * @date  2023/8/17 19:19
 * @version 1.0
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    //第一种方式 属性注入
    @Autowired
    @Override
    public void add() {
        System.out.println("userDao.add()...");
    }
}
