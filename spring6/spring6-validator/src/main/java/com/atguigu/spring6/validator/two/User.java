package com.atguigu.spring6.validator.two;
/*
 * @author  AmbitionJingH
 * @date  2023/8/21 9:58
 * @version 1.0
 */

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class User {
    @NotNull
    private String name;
    @Min(0)
    @Max(150)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
