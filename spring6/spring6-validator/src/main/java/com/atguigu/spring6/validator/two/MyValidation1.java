package com.atguigu.spring6.validator.two;
/*
 * @author  AmbitionJingH
 * @date  2023/8/21 10:00
 * @version 1.0
 */

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MyValidation1 {
    @Autowired
    private Validator validator;
    public boolean validatorByUser(User user){
        Set<ConstraintViolation<User>> validate = validator.validate(user);
        return validate.isEmpty();
    }
}
