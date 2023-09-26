package com.ambitionjh.auth;

import com.ambitionjh.auth.mapper.SysRoleMapper;
import com.ambitionjh.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/*
 * @author  AmbitionJingH
 * @date  2023/9/24 15:41
 * @version 1.0
 */
@SpringBootTest
public class TestMpDemo1 {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    //查询所有记录
    @Test
    public void getAll(){
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        System.out.println(sysRoles);
    }
}
