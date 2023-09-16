package com.atguigu.boot.controller;
/*
 * @author  AmbitionJingH
 * @date  2023/9/16 16:00
 * @version 1.0
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String HELLO(){
        return "hello,我是超凡";
    }
}
