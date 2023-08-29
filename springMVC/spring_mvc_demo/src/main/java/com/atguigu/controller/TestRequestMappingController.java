package com.atguigu.controller;
/*
 * @author  AmbitionJingH
 * @date  2023/8/24 16:09
 * @version 1.0
 *
 * 1、@RequestMapping注解的位置：
 * @RequestMapping标识一个类：设置映射请求的请求路径的初始信息
 * @RequestMapping标识一个方法：设置映射请求请求路径的具体信息
 * 2、@RequestMapping注解的value属性：
 *    value属性通过请求的请求地址匹配请求映射
 *    value属性是一个字符串类型的数组，表示该请求映射能够匹配多个请求地址所对应的请求
 *    value属性必须设置，至少通过请求地址匹配请求映射
 * 3、@RequestMapping注解的method属性：
 *    @RequestMapping注解的method属性通过请求的请求方式（get或post）匹配请求映射
 *    @RequestMapping注解的method属性是一个RequestMethod类型的数组，
 *     表示该请求映射能够匹配多种请求方式的请求若当前请求的请求地址满足请求映射的value属性，但是请求方式不满足method属性，则浏览器报错
 * 4、对于处理指定请求方式的控制器方法，SpringMVC中提供了@RequestMapping的派生注解
 *      处理get请求的映射-->@GetMapping
 *      处理post请求的映射-->@PostMapping
 *      处理put请求的映射-->@PutMapping
 *      处理delete请求的映射-->@DeleteMapping
 * 5、@RequestMapping注解的params属性通过请求的请求参数匹配请求映射
 *   @RequestMapping注解的params属性是一个字符串类型的数组，可以通过四种表达式设置请求参数请求映射的匹配关系
 *      "param"：要求请求映射所匹配的请求必须携带param请求参数
 *      "!param"：要求请求映射所匹配的请求必须不能携带param请求参数
 *      "param=value"：要求请求映射所匹配的请求必须携带param请求参数且param=value
 *      "param!=value"：要求请求映射所匹配的请求必须携带param请求参数但是param!=value
 * 6、@RequestMapping注解的headers属性:
 *      @RequestMapping注解的headers属性通过请求的请求头信息匹配请求映射
 *      若当前请求满足@RequestMapping注解的value和method属性，但是不满足headers属性，此时页面显示404错误，即资源未找到
 *7、SpringMVC支持ant风格的路径
 *      在@RequestMapping注解的value属性值中设置一些特殊字符
 *      ?：任意的单个字符(不包括?)
 *      *：任意个数的任意字符（不包括?和/）
 *      **：任意层数的目录 注意使用方式只能将**写在双斜线中，前后不能有任何的其他字符
 * 8、@RequestMapping注解使用路径中的占位符
 *      传统：/deleteUser?id=1
 *      rest：/user/delete/1
 *      需要在@RequestMapping注解的value属性中所设置的路径中，使用{xxx}的方式表示路径中的数据
 *      在通过@PathVariable注解，将占位符所标识的值和控制器方法的形参进行绑定
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {
    @RequestMapping(value = {"/hello","abc"},
                    method = {RequestMethod.POST,RequestMethod.GET},
                    params = {"username","!password","age=20","gender!=女"},
                    headers = "referer"
    )
    public String hello(){
        return "success";
    }
    @RequestMapping("/**/test/ant")
    public String testAnt(){
        return "success";
    }
    @RequestMapping("/test/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id,@PathVariable("username") String username){
        System.out.println("id:"+id+"   username:"+username);
        return "success";
    }
}
