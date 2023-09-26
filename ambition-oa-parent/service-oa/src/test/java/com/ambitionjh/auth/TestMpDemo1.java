package com.ambitionjh.auth;

import com.ambitionjh.auth.mapper.SysRoleMapper;
import com.ambitionjh.model.system.SysRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
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

    //添加操作
    @Test
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("role");
        sysRole.setDescription("角色管理员");
        int rows = sysRoleMapper.insert(sysRole);
        System.out.println("rows = " + rows);
        System.out.println(sysRole.getId());
    }

    @Test
    public void update(){
        SysRole sysRole = sysRoleMapper.selectById(9);
        sysRole.setDescription("我被修改了");
        sysRole.setRoleName("91角色管理员");
        int rows = sysRoleMapper.updateById(sysRole);
        System.out.println("rows = " + rows);
    }

    @Test
    public void deleteId(){
        int rows = sysRoleMapper.deleteById(9);
        System.out.println("rows = " + rows);
    }

    @Test
    public void deleteBatchIds(){
        int rows = sysRoleMapper.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println("rows = " + rows);
    }

    //条件查询
    @Test
    public void testQuery1(){
        //创建QueryWrapper对象，调用方法封装条件
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_name","总经理");
        //调用mp方法实现查询操作
        List<SysRole> roleList = sysRoleMapper.selectList(queryWrapper);
        System.out.println(roleList);
    }

    @Test
    public void testQuery2(){
        //创建LambdaQueryWrapper对象，调用方法封装条件
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysRole::getRoleName,"总经理");
        //调用mp方法实现查询操作
        List<SysRole> roleList = sysRoleMapper.selectList(queryWrapper);
        System.out.println(roleList);
    }
}
