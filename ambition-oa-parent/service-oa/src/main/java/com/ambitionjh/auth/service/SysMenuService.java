package com.ambitionjh.auth.service;


import com.ambitionjh.model.system.SysMenu;
import com.ambitionjh.vo.system.AssginMenuVo;
import com.ambitionjh.vo.system.AssginRoleVo;
import com.ambitionjh.vo.system.RouterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author ambitionjh
 * @since 2023-10-03
 */
public interface SysMenuService extends IService<SysMenu> {

    //菜单列表接口
    List<SysMenu> findNodes();
    //删除菜单
    void RemoveMenuById(Long id);

    List<SysMenu> findMenuByRoleId(Long roleId);

    void doAssign(AssginMenuVo assginMenuVo);

    List<RouterVo> findUserMenuListByUserId(Long userId);

    List<String> findUserPermsByUserId(Long userId);
}
