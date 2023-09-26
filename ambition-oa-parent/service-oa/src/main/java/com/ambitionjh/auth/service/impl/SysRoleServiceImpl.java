package com.ambitionjh.auth.service.impl;
/*
 * @author  AmbitionJingH
 * @date  2023/9/24 17:39
 * @version 1.0
 */

import com.ambitionjh.auth.mapper.SysRoleMapper;
import com.ambitionjh.auth.service.SysRoleService;
import com.ambitionjh.model.system.SysRole;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

}
