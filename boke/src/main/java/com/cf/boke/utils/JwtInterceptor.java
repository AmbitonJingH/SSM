package com.cf.boke.utils;
/*
 * @author  AmbitionJingH
 * @date  2023/12/7 9:53
 * @version 1.0
 */

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cf.boke.entity.User;
import com.cf.boke.exception.BokeException;
import com.cf.boke.service.UserService;
import com.cf.boke.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {

    @Resource
    private UserService userService;
//    @Resource
//    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token"); // header里面传过来的参数
        if (StrUtil.isBlank(token)) {
            token = request.getParameter("token");  //url ?token=xxxx
        }
        // 执行认证
        if (StrUtil.isBlank(token)) {
            throw new BokeException(201, "请登录");
        }
        // 获取 token 中的 user id
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);  //JWT.decode(token)解码 jwt token
        } catch (JWTDecodeException j) {
            throw new BokeException(201, "请登录");
        }
        // 根据token中的userid查询数据库
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getId,Integer.valueOf(userId));
        User user = userService.getOne(wrapper);
        if (user == null) {
            throw new BokeException(201, "请登录");
        }
        //通过 用户密码加签验证生成一个验证器验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token); // 验证token
        } catch (JWTVerificationException e) {
            throw new BokeException(201, "请登录");
        }
        return true;
    }

}
