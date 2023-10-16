package com.ambitionjh.auth.Activiti;

import org.springframework.stereotype.Component;

/*
 * @author  AmbitionJingH
 * @date  2023/10/16 21:32
 * @version 1.0
 */
@Component
public class User {
    public String getUsername(int id){
        if (id==1)
            return "yzf";
        else if (id == 2) {
            return "cxk";
        }else
            return "admin";
    }
}
