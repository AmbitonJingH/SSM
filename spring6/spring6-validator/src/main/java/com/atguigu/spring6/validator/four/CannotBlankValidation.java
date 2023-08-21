package com.atguigu.spring6.validator.four;
/*
 * @author  AmbitionJingH
 * @date  2023/8/21 12:42
 * @version 1.0
 */

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CannotBlankValidation implements ConstraintValidator<CannotBlank,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //null时不进行校验
        if (value != null && value.contains(" ")) {
            //获取默认提示信息
            String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
            System.out.println("default message :" + defaultConstraintMessageTemplate);
            //禁用默认提示信息
            context.disableDefaultConstraintViolation();
            //设置提示语
            context.buildConstraintViolationWithTemplate("can not contains blank").addConstraintViolation();
            return false;
        }
        return false;
    }
}
