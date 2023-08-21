package com.atguigu.spring6.validator.three;
/*
 * @author  AmbitionJingH
 * @date  2023/8/21 10:12
 * @version 1.0
 */


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import java.lang.reflect.Method;

@Configuration
@ComponentScan("com.atguigu.spring6.validator.three")
public class ValidationConfig {
    @Bean
    public MethodValidationPostProcessor validationPostProcessor(){
        return new MethodValidationPostProcessor();
    }
}
