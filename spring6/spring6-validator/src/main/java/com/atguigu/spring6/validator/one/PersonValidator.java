package com.atguigu.spring6.validator.one;
/*
 * @author  AmbitionJingH
 * @date  2023/8/21 9:40
 * @version 1.0
 */

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }


    //校验规则
    @Override
    public void validate(Object target, Errors errors) {
        //name不能为空
        ValidationUtils.rejectIfEmpty(errors,"name","name.empty","姓名为空");
        //age不能为0不能大于200
        Person p = (Person) target;
        if(p.getAge()<0){
            errors.rejectValue("age","age.value.error","年龄小于0岁");
        } else if (p.getAge() > 200) {
            errors.rejectValue("age","age.value.error.old","年龄大于200岁");
        }

    }
}
