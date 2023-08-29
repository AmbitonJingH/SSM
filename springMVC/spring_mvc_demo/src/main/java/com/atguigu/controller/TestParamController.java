package com.atguigu.controller;
/*
 * @author  AmbitionJingH
 * @date  2023/8/24 18:32
 * @version 1.0
 *
 * 获取请求参数的方式：
 *  1、通过servletAPI获取
 *  只需要在控制器方法的形参位置设置HttpServletRequest类型的形参
 *  就可以在控制器方法中使用request对象获取请求参数
 *  2、通过控制器方法的形参获取
 *  只需要在控制器方法的形参位置，设置一个形参，形参的名字和请求参数的名字一致即可
 *  3、@RequestParam：将请求参数和控制器方法的形参绑定
 *   @RequestParam注解的三个属性：value、required、defaultValue
 *     value：设置和形参绑定的请求参数的名字
 *     required：设置是否必须传输value所对应的请求参数
 *               默认值为true，表示value所对应的请求参数必须传输，否则报错（Required String parameter 'username' is not present）
 *               false，则当前请求不是必须传输value所指定的请求参数，若没有传输，则注解所标识的形参的值为null
 *     defaultValue：不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值
 *  4、@RequestHeader是将请求头信息和控制器方法的形参创建映射关系
 *     @RequestHeader注解一共有三个属性：value、required、defaultValue，用法同@RequestParam
 *  5、@CookieValue是将cookie数据和控制器方法的形参创建映射关系
 *     @CookieValue注解一共有三个属性：value、required、defaultValue，用法同@RequestParam
 *  6、可以在控制器方法的形参位置设置一个实体类类型的形参，此时若浏览器传输的请求参数的参数名和实体类中的属性名一致，那么请求参数就会为此属性赋值
 *  7、解决获取请求参数的乱码问题，可以使用SpringMVC提供的编码过滤器CharacterEncodingFilter，但是必须在web.xml中进行注册
 */

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestParamController {
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "success";
    }

    @RequestMapping("/param")
    //@RequestParam("参数") 参数要和页面的请求参数name相同
    public String getParam(@RequestParam(value = "username",required = false ,defaultValue = "用户") String username,
                           @RequestParam("password") String password,
                           @RequestHeader("referer") String referer,
                           @CookieValue("JSESSIONID") String jsessionId){
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("referer = " + referer);
        System.out.println("jsessionId = " + jsessionId);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }

}
