package com.atguigu.controller;
/*
 * @author  AmbitionJingH
 * @date  2023/8/30 16:53
 * @version 1.0
 *
 * 查询所有用户信息：/user-->get
 * 查询id查询所有用户信息：/user/1-->get
 * 添加用户信息：/user-->post
 * 修改用户信息：/user-->put
 * 删除用户信息：/user-->delete
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestRestController {

    //@RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping(value = "/user")
    public String getAllUser(){
        System.out.println("查询所有用户信息：/user-->get");
        return "success";
    }

    //@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    @GetMapping(value = "/user/{id}")
    public String getUserById(@PathVariable("id")Integer id){
        System.out.println("查询id查询所有用户信息：/user/"+id+"-->get");
        return "success";
    }

    //@RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String addUser(){
        System.out.println("添加用户信息：/user-->post");
        return "success";
    }

    //@RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping(value = "/user")
    public String updateUser(){
        System.out.println("修改用户信息：/user-->put");
        return "success";
    }

    //@RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    @DeleteMapping(value = "/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("删除用户信息：/user/"+id+"-->delete");
        return "success";
    }
}
