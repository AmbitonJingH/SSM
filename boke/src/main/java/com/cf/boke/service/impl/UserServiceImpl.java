package com.cf.boke.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cf.boke.entity.User;
import com.cf.boke.mapper.UserMapper;
import com.cf.boke.service.UserService;
import org.springframework.stereotype.Service;

/*
 * @author  AmbitionJingH
 * @date  2023/12/1 20:06
 * @version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
