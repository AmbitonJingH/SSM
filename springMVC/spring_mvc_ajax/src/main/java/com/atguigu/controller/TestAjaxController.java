package com.atguigu.controller;
/*
 * @author  AmbitionJingH
 * @date  2023/9/1 9:56
 * @version 1.0
 */

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
//@RestController  == @Controller+@ResponseBody
public class TestAjaxController {

    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("requestBody = " + requestBody);
        System.out.println("id = " + id);
        response.getWriter().write("hello,axios");
        //return "";
    }

    @RequestMapping("/test/RequestBody/json")
    public void testRequestBody(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException {
        System.out.println(map);
        response.getWriter().write("hello,requestBody");
    }

    //@RequestMapping("/test/RequestBody/json")
    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println(user);
        response.getWriter().write("hello,requestBody");
    }

    //@ResponseBody用于标识一个控制器方法，可以将该方法的返回值直接作为响应报文的响应体响应到浏览器
    @RequestMapping("/test/ResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "yuan shen zen me ni le？";
    }

    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    public List<User> testResponseJson(){
        User user1 = new User(1001,"黄浩","666",19,"女");
        User user2 = new User(1002,"黄浩","666",19,"女");
        User user3 = new User(1003,"黄浩","666",19,"女");
        List<User> list = Arrays.asList(user1, user2, user3);
        return list;
    }
//    public Map<String,Object> testResponseJson(){
//        User user1 = new User(1001,"黄浩","666",19,"女");
//        User user2 = new User(1002,"黄浩","666",19,"女");
//        User user3 = new User(1003,"黄浩","666",19,"女");
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("1001",user1);
//        map.put("1002",user2);
//        map.put("1003",user3);
//        return map;
//    }
//    public User testResponseJson(){
//        User user = new User(1001,"黄浩","666",19,"女");
//        return user;
//    }
}
