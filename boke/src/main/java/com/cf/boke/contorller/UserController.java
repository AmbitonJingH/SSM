package com.cf.boke.contorller;

import com.cf.boke.entity.User;
import com.cf.boke.result.Result;
import com.cf.boke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author  AmbitionJingH
 * @date  2023/12/1 20:07
 * @version 1.0
 */
@RestController
@RequestMapping("/boke/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("update")
    public Result update(@RequestBody User tempUser){
        boolean updated = userService.updateById(tempUser);
        if (updated){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }
}
