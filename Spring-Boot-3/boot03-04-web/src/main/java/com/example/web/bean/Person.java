package com.example.web.bean;
/*
 * @author  AmbitionJingH
 * @date  2023/9/18 23:03
 * @version 1.0
 */


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JacksonXmlRootElement  // 可以写出为xml文档
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Long id;
    private String userName;
    private String email;
    private Integer age;
    private String role;
}

