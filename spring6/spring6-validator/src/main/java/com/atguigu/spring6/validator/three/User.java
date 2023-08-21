package com.atguigu.spring6.validator.three;
/*
 * @author  AmbitionJingH
 * @date  2023/8/21 10:13
 * @version 1.0
 */

import com.atguigu.spring6.validator.four.CannotBlank;
import jakarta.validation.constraints.*;

public class User {
    @NotNull
    private String name;
    @Min(0)
    @Max(150)
    private Integer age;
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
    @NotBlank(message = "手机号码不能为空")
    private String phone;
    @CannotBlank
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
