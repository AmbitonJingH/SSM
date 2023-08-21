package com.atguigu.spring6.validator.three;
/*
 * @author  AmbitionJingH
 * @date  2023/8/21 10:15
 * @version 1.0
 */

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class MyService {
    public String testMethod(@NotNull @Valid User user){
        return user.toString();
    }
}
