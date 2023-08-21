package com.atguigu.spring6.validator.one;
/*
 * @author  AmbitionJingH
 * @date  2023/8/21 9:46
 * @version 1.0
 */

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

public class TestPerson {
    public static void main(String[] args) {
        //创建Person对象
        Person person = new Person();
        person.setName("lucy");
        person.setAge(201);
        //创建Person对应的databinder
        DataBinder dataBinder = new DataBinder(person);
        //设置校验器
        PersonValidator validator = new PersonValidator();
        dataBinder.setValidator(validator);
        //调用方法执行校验
        dataBinder.validate();
        //输入校验结果
        BindingResult result = dataBinder.getBindingResult();
        System.out.println(result.getAllErrors());
    }
}
