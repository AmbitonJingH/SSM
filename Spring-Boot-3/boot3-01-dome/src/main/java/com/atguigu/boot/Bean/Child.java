package com.atguigu.boot.Bean;
/*
 * @author  AmbitionJingH
 * @date  2023/9/17 17:17
 * @version 1.0
 */

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Child {
    private String name;
    private Integer age;
    private Date birthDay;
    private List<String> text; //数组
}
