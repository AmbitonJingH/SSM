package com.atguigu.spring6.validator.one;
/*
 * @author  AmbitionJingH
 * @date  2023/8/21 9:39
 * @version 1.0
 */

public class Person {
    private String name;
    private Integer age = 20;

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
