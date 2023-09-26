package com.ambitionjh.auth;
/*
 * @author  AmbitionJingH
 * @date  2023/9/24 17:44
 * @version 1.0
 */

import com.ambitionjh.auth.service.SysRoleService;
import com.ambitionjh.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestDemo2 {
    @Autowired
    private SysRoleService service;
    @Test
    public void getAll(){
        List<SysRole> list = service.list();
        System.out.println(list);
    }
}
