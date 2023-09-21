package com.example.web.handler;
/*
 * @author  AmbitionJingH
 * @date  2023/9/20 16:23
 * @version 1.0
 */

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice //这个类是集中处理所有 @Controller 发生的错误
public class GlobalExceptionHandler {

    @ResponseBody //对象写出为json
    @ExceptionHandler(Exception.class)
    public String handlerException(Exception e){
        return "ohho~~统一处理,原因：" + e.getMessage();
    }
}
