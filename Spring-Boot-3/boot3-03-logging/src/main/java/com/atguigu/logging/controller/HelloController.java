package com.atguigu.logging.controller;
/*
 * @author  AmbitionJingH
 * @date  2023/9/17 22:33
 * @version 1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("/h")
    public String hello(){
        //logger.info("hello(),方法进来了");
        for (int i=0;i<1000;i++) {
            log.info("hello(),方法进来了");
        }
        return "hello";
    }
}
