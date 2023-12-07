package com.cf.boke.utils;
/*
 * @author  AmbitionJingH
 * @date  2023/12/7 9:54
 * @version 1.0
 */

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cf.boke.entity.User;
import com.cf.boke.service.UserService;
import com.cf.boke.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class TokenUtils {

    @Autowired
    private static UserService userService;
    //private static UserMapper staticUserMapper;

    //@Resource
    //UserMapper userMapper;

   // @PostConstruct
    //public void setUserService() {
        //staticUserMapper = userMapper;
    //}

    /**
     * 生成token
     *
     * @return
     */
    public static String createToken(String userId, String sign) {
        return JWT.create().withAudience(userId) // 将 user id 保存到 token 里面,作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(), 2)) // 2小时后token过期
                .sign(Algorithm.HMAC256(sign)); // 以 password 作为 token 的密钥
    }

    /**
     * 获取当前登录的用户信息
     *
     * @return user对象
     */
    public static String getUserId() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            if (StrUtil.isNotBlank(token)) {
                String userId = JWT.decode(token).getAudience().get(0);
//                System.out.println(userId+"--------------------");
//                LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
//                wrapper.eq(User::getId,Integer.valueOf(userId));
//                User user = userService.getOne(wrapper);
//                System.out.println(user);
                //return userService.getOne(wrapper);
                return userId;
              //  return userService.selectById(Integer.valueOf(userId));
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        int userid = 1;
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getId,userid);
        User user = service.getOne(wrapper);
        System.out.println(user);
    }
}
