package com.atguigu.controller;
/*
 * @author  AmbitionJingH
 * @date  2023/8/29 15:16
 * @version 1.0
 *
 * 1、使用ModelAndView向请求域共享数据
 * 2、使用Model向请求域共享数据
 * 3、使用ModelMap向请求域共享数据
 * 4、使用map向请求域共享数据
 * 5、Model、ModelMap、Map的关系
 *    Model、ModelMap、Map类型的参数其实本质上都是 BindingAwareModelMap 类型的
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Objects;

@Controller
public class TestScopeController {

    @RequestMapping("/test/mav")
    public ModelAndView testMAV(){
        /*
        * ModelAndView包含Model和View的功能
        * Model：向请求域中共享数据
        * View：设置罗逻辑视图实现页面跳转
        * */
        ModelAndView mav = new ModelAndView();
        //向请求域中共享数据
        mav.addObject("testRequestScope","hello,ModelAndView");
        //设置罗逻辑视图实现页面跳转
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model){
        System.out.println(model.getClass().getName());
        model.addAttribute("testRequestScope","hello,Model");
        return "success";
    }
    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap){
        System.out.println(modelMap.getClass().getName());
        modelMap.addAttribute("testRequestScope","hello,modelMap");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String, Object> map){
        System.out.println(map.getClass().getName());
        map.put("testRequestScope","hello,map");
        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","hello,session");
        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession session){
        ServletContext context = session.getServletContext();
        context.setAttribute("testApplicationScope","hello,application");
        return "success";
    }
}
