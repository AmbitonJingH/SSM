package com.atguigu.spring6.resource.service;

import com.atguigu.spring6.resource.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
 * @author  AmbitionJingH
 * @date  2023/8/17 19:19
 * @version 1.0
 */
@Service("myUserService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao myUserDao;
    @Override
    public void add() {
        System.out.println("userService.add()...");
        myUserDao.add();
    }
}
