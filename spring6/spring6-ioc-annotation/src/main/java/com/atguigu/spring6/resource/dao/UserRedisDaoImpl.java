package com.atguigu.spring6.resource.dao;
/*
 * @author  AmbitionJingH
 * @date  2023/8/18 14:57
 * @version 1.0
 */


import org.springframework.stereotype.Repository;

@Repository("myUserRedisDao")
public class UserRedisDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao redis......");
    }
}
