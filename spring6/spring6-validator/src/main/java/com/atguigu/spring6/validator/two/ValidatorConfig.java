package com.atguigu.spring6.validator.two;
/*
 * @author  AmbitionJingH
 * @date  2023/8/21 9:57
 * @version 1.0
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan("com.atguigu.spring6.validator.two")
public class ValidatorConfig {
    @Bean
    public LocalValidatorFactoryBean Validator(){
        return new LocalValidatorFactoryBean();
    }
}
