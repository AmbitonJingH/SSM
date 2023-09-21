package com.example.web.controller;
/*
 * @author  AmbitionJingH
 * @date  2023/9/19 16:40
 * @version 1.0
 */

import com.example.web.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.Arrays;
import java.util.List;

@Controller // 适配服务端渲染
public class WelcomeController {

    @GetMapping("/nihao")
    public String hello(@RequestParam("name") String name, Model model){
        String text = "<span style='color:red'>"+name+"</span>";
        model.addAttribute("text",text);
        model.addAttribute("name",name);
        model.addAttribute("imgUrl","/1.jpg");
        model.addAttribute("style","width:400px");
        model.addAttribute("show",false);
        return "welcome";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Person> list = Arrays.asList(
                new Person(1l,"张三","zs@qq.com",15,"pm"),
                new Person(3l,"sad","z2s@qq.com",22,"admin"),
                new Person(5l,"dfd","zs3@qq.com",15,"hr"),
                new Person(11l,"sd","zs5@qq.com",15,"pm"),
                new Person(14l,"张fbfd三","zs34@qq.com",15,"pm"),
                new Person(17l,"dfgfd","z1s@qq.com",15,"pm"));
        model.addAttribute("list",list);
        int i = 10/0;
        return "list";
    }


}
