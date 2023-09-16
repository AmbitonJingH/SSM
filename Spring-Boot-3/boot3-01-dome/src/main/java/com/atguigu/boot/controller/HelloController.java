package com.atguigu.boot.controller;
/*
 * @author  AmbitionJingH
 * @date  2023/9/16 15:31
 * @version 1.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//@ResponseBody
//@Controller
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello,Spring Boot 3!";
    }
}
