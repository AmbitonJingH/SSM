package com.ambitionjh.auth.service;
/*
 * @author  AmbitionJingH
 * @date  2023/9/24 17:39
 * @version 1.0
 */

import com.ambitionjh.model.system.SysRole;
import com.ambitionjh.vo.system.AssginRoleVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface SysRoleService extends IService<SysRole> {
    Map<String, Object> findRoleDataByUserId(Long userId);

    void doAssign(AssginRoleVo assginRoleVo);
}
