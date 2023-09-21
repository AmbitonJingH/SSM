package com.example.web.controller;
/*
 * @author  AmbitionJingH
 * @date  2023/9/18 22:46
 * @version 1.0
 */

import com.example.web.bean.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class HelloController {

    //springBoot默认使用新版 PathPatternParser 进行路径匹配
    //新版 PathPatternParser 不能匹配 ** 在路径中间的情况，剩下的和antPathMatcher语法兼容
    @GetMapping("/ABC")
    public String hello(HttpServletRequest request,@PathVariable("p1") String path){
        log.info("路径变量p1:{}" + path);
        String uri = request.getRequestURI();
        return uri;
    }

    /*
    * 1、默认支持把对象写为json。因为默认web场景导入了jackson处理json的包;jackson-core
    * 2、jackson也支持把数据携程xml。需要导入相关依赖
    * */
    @GetMapping("/person")
    public Person person(){
        Person person = new Person();
        person.setId(1l);
        person.setUserName("三张");
        person.setAge(18);
        person.setEmail("cf123@qq.com");
        return person;
    }

    public static void main(String[] args) throws JsonProcessingException {
        Person person = new Person();
        person.setId(1l);
        person.setUserName("三张");
        person.setAge(18);
        person.setEmail("cf123@qq.com");
        YAMLFactory factory = new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        ObjectMapper mapper = new ObjectMapper(factory);
        String s = mapper.writeValueAsString(person);
        System.out.println(s);
    }
}
