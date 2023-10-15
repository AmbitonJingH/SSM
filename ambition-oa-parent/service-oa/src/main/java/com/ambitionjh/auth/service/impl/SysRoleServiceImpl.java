package com.ambitionjh.auth.service.impl;
/*
 * @author  AmbitionJingH
 * @date  2023/9/24 17:39
 * @version 1.0
 */

import com.ambitionjh.auth.mapper.SysRoleMapper;
import com.ambitionjh.auth.service.SysRoleService;
import com.ambitionjh.auth.service.SysUserRoleService;
import com.ambitionjh.model.system.SysRole;
import com.ambitionjh.model.system.SysUserRole;
import com.ambitionjh.vo.system.AssginRoleVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Override
    public Map<String, Object> findRoleDataByUserId(Long userId) {
        //1.查询所有角色，返回list集合
        List<SysRole> AllRoleList = baseMapper.selectList(null);
        //2、根据userid查询角色用户关系表，查询userid对应所有角色id
        LambdaQueryWrapper<SysUserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUserRole::getUserId,userId);
        List<SysUserRole> userRoleList = sysUserRoleService.list(wrapper);
        /*List<Long> userRoleIdList = new ArrayList<>();
        for(SysUserRole sysUserRole:userRoleList){
            userRoleIdList.add(sysUserRole.getRoleId());
        }*/
        List<Long> userRoleIdList = userRoleList.stream().map(c -> c.getRoleId()).collect(Collectors.toList());
        //3、根据查询所有角色id，找到对应角色信息
        //  根据角色id到所有角色的list集合进行比较
        List<SysRole> assignRoleList = new ArrayList<>();
        for(SysRole sysRole:AllRoleList){
            if(userRoleIdList.contains(sysRole.getId()))
                assignRoleList.add(sysRole);
        }
        //4、把得到的两部分数据封装map集合，返回
        Map<String, Object> roleMap = new HashMap<>();
        roleMap.put("assginRoleList", assignRoleList);
        roleMap.put("allRolesList", AllRoleList);
        return roleMap;
    }

    @Override
    public void doAssign(AssginRoleVo assginRoleVo) {
        //把用户之前分配的角色数据删除
        LambdaQueryWrapper<SysUserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUserRole::getUserId,assginRoleVo.getUserId());
        boolean removed = sysUserRoleService.remove(wrapper);
        //重新进行分配
        List<Long> roleIdList = assginRoleVo.getRoleIdList();
        for (Long roleId:roleIdList){
            if(StringUtils.isEmpty(roleId)) {
                continue;
            }
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(assginRoleVo.getUserId());
            sysUserRole.setRoleId(roleId);
            sysUserRoleService.save(sysUserRole);
        }
    }
}
