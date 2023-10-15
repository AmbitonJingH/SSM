package com.ambitionjh.auth.service.impl;
/*
 * @author  AmbitionJingH
 * @date  2023/10/5 15:07
 * @version 1.0
 */


import com.ambitionjh.auth.service.SysMenuService;
import com.ambitionjh.auth.service.SysUserService;
import com.ambitionjh.model.system.SysUser;
import com.ambitionjh.security.custom.CustomUser;
import com.ambitionjh.security.custom.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysMenuService sysMenuService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.getUserByUserName(username);
        if (sysUser == null){
            throw new UsernameNotFoundException("用户名不存在!");
        }
        if(sysUser.getStatus().intValue()==0)
            throw new RuntimeException("账号已停用");
        //根据userId查询用户操作权限
        List<String> userPermsList = sysMenuService.findUserPermsByUserId(sysUser.getId());
        //创建list集合，封装最终权限数据集合
        List<SimpleGrantedAuthority> authList = new ArrayList<>();
        for(String perm : userPermsList){
            authList.add(new SimpleGrantedAuthority(perm.trim()));
        }
        return new CustomUser(sysUser, authList);
    }
}
