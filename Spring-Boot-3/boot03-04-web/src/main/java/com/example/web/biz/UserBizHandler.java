package com.example.web.biz;
/*
 * @author  AmbitionJingH
 * @date  2023/9/21 15:18
 * @version 1.0
 * 专门处理User的业务
 */

import com.example.web.bean.Person;
import jakarta.servlet.ServletException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class UserBizHandler {
    public ServerResponse getUser(ServerRequest request) throws Exception{
        String id = request.pathVariable("id");
        log.info("查询【{}】用户信息，续数据库检索中",id);
        //业务处理
        Person person = new Person(1l, "hh", "aa@qq.com", 20, "admin");
        //构造响应
        return ServerResponse
                .ok()
                .body(person);
    }

    public ServerResponse getUsers(ServerRequest request) throws Exception{
        //业务处理
        List<Person> list = Arrays.asList(new Person(1l, "hh", "aa@qq.com", 20, "admin"),
                new Person(2l, "fwshh", "aasdasa@qq.com", 26, "pm"),
                new Person(3l, "hdsweh", "a12a@qq.com", 40, "hr"),
                new Person(4l, "h23h", "r5453aa@qq.com", 54, "pm"),
                new Person(5l, "h32h", "a232a@qq.com", 27, "pm"));
        //构造响应
        return ServerResponse
                .ok()
                .body(list);//body()中的对象就是以前@ResponseBody原理。利用HttpMessageConverter写出为json
    }

    public ServerResponse updateUsers(ServerRequest request) throws Exception{
        Person body = request.body(Person.class);
        log.info("用户信息更新:{}",body);
        //业务处理
        //Person person = new Person(1l, "hh", "aa@qq.com", 20, "admin");
        //构造响应
        return ServerResponse
                .ok()
                .build();
    }

    public ServerResponse deleteUsers(ServerRequest request) throws Exception{
        String id = request.pathVariable("id");
        log.info("删除【{}】用户信息",id);
        //业务处理
        //Person person = new Person(1l, "hh", "aa@qq.com", 20, "admin");
        //构造响应
        return ServerResponse
                .ok()
                .build();
    }

    public ServerResponse insertUser(ServerRequest serverRequest) throws ServletException, IOException {
        Person person = serverRequest.body(Person.class);
        log.info("保存用户信息：{}",person);
        return ServerResponse.ok().build();
    }
}
