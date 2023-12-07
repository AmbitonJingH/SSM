package com.cf.boke.contorller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cf.boke.entity.User;
import com.cf.boke.exception.BokeException;
import com.cf.boke.result.Result;
import com.cf.boke.service.UserService;
import com.cf.boke.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * @author  AmbitionJingH
 * @date  2023/12/2 22:14
 * @version 1.0
 */
@RestController
@RequestMapping("/admin/system/index")
@CrossOrigin
public class IndexController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public Result register(@RequestBody User tempUser){
        String username = tempUser.getUsername();
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,username);
        User user = userService.getOne(wrapper);
        if (user != null){
            throw new BokeException(201,"用户名已存在！");
        }
        userService.save(tempUser);
        return Result.ok();
    }

    @PostMapping("login")
    public Result login(@RequestBody User tempUser){
        String username = tempUser.getUsername();
        String password = tempUser.getPassword();
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,username).eq(User::getPassword,password);
        User user = userService.getOne(wrapper);
        if (user == null){
            throw new BokeException(201,"用户不存在！");
        }
        user.setToken(TokenUtils.createToken(String.valueOf(user.getId()),user.getPassword()));
        return Result.ok(user);
    }
}
