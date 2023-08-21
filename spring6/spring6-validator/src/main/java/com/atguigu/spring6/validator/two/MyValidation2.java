package com.atguigu.spring6.validator.two;
/*
 * @author  AmbitionJingH
 * @date  2023/8/21 10:00
 * @version 1.0
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import java.util.List;

@Service
public class MyValidation2 {
    @Autowired
    private Validator validator;
    public boolean validatorByTwo(User user){
        BindException bindException = new BindException(user, user.getName());
        validator.validate(user,bindException);
        List<ObjectError> allErrors = bindException.getAllErrors();
        System.out.println(allErrors);
        return bindException.hasErrors();
    }
}
