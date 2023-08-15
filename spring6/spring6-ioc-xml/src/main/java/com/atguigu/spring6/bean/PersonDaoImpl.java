package com.atguigu.spring6.bean;
/*
 * @author  AmbitionJingH
 * @date  2023/8/15 19:46
 * @version 1.0
 */

public class PersonDaoImpl implements UserDao{
    @Override
    public void run() {
        System.out.println("personDao也跑");
    }
}
