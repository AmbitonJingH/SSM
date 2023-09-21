package com.atguigu.ssm.bean;

import lombok.Data;

/*
 * @author  AmbitionJingH
 * @date  2023/9/21 23:39
 * @version 1.0
 */
@Data
public class TUser {
    private Long id;
    private String loginName;
    private String nickName;
    private String passwd;
}
