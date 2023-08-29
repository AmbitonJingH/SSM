package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @author  AmbitionJingH
 * @date  2023/8/24 11:06
 * @version 1.0
 */

@Controller
public class HelloController {
    @RequestMapping("/")
    public String portal(){
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }
}
