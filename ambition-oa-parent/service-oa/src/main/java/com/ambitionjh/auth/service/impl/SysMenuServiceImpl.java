package com.ambitionjh.auth.service.impl;


import com.ambitionjh.auth.mapper.SysMenuMapper;
import com.ambitionjh.auth.service.SysMenuService;
import com.ambitionjh.auth.service.SysRoleMenuService;
import com.ambitionjh.auth.utils.MenuHelper;
import com.ambitionjh.common.config.exception.GuiguException;
import com.ambitionjh.model.system.SysMenu;
import com.ambitionjh.model.system.SysRoleMenu;
import com.ambitionjh.vo.system.AssginMenuVo;
import com.ambitionjh.vo.system.AssginRoleVo;
import com.ambitionjh.vo.system.MetaVo;
import com.ambitionjh.vo.system.RouterVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author ambitionjh
 * @since 2023-10-03
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    //菜单列表接口
    @Override
    public List<SysMenu> findNodes() {
        //1、查询菜单表中所有数据
        List<SysMenu> sysMenuList = baseMapper.selectList(null);
        List<SysMenu> ResultList = MenuHelper.buildTree(sysMenuList);
        return ResultList;
    }

    @Override
    public void RemoveMenuById(Long id) {
        //判断当前菜单是否有子菜单
        LambdaQueryWrapper<SysMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysMenu::getParentId,id);
        Integer count = baseMapper.selectCount(wrapper);
        if(count>0){
            throw new GuiguException(201,"存在子菜单，不能删除！");
        }
        baseMapper.deleteById(id);
    }

    @Override
    public List<SysMenu> findMenuByRoleId(Long roleId) {
        //1、查询所有菜单(status==1)
        LambdaQueryWrapper<SysMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysMenu::getStatus,1);
        List<SysMenu> AllSysMenuList = baseMapper.selectList(wrapper);
        //2、根据角色id roleId查询 角色菜单关系表里 角色Id对应的所有菜单的id
        LambdaQueryWrapper<SysRoleMenu> wrapperSysRoleMenu = new LambdaQueryWrapper<>();
        wrapperSysRoleMenu.eq(SysRoleMenu::getRoleId,roleId);
        List<SysRoleMenu> sysRoleMenuList = sysRoleMenuService.list(wrapperSysRoleMenu);
        //3、根据获取菜单id，获取对应菜单对象
        List<Long> menuIdList = sysRoleMenuList.stream().map(c -> c.getMenuId()).collect(Collectors.toList());
        //3.1 拿着菜单id和菜单集合id进行比较，如果相同封装
        AllSysMenuList.stream().forEach(item -> {
            if(menuIdList.contains(item.getId())){
                item.setSelect(true);
            }
        });
        //4、返回规定树形显示格式菜单列表
        List<SysMenu> sysMenuList = MenuHelper.buildTree(AllSysMenuList);
        return sysMenuList;
    }

    @Override
    public void doAssign(AssginMenuVo assginMenuVo) {
        //1.根据角色id ，删除菜单角色表
        LambdaQueryWrapper<SysRoleMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRoleMenu::getRoleId,assginMenuVo.getRoleId());
        sysRoleMenuService.remove(wrapper);
        //2.从参数里面获取角色新分配菜单id列表，进行遍历，把每个数据添加到菜单角色表
        List<Long> menuIdList = assginMenuVo.getMenuIdList();
        for(Long menuId : menuIdList){
            if(StringUtils.isEmpty(menuId)){
                continue;
            }
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setMenuId(menuId);
            sysRoleMenu.setRoleId(assginMenuVo.getRoleId());
            sysRoleMenuService.save(sysRoleMenu);
        }
    }

    @Override
    public List<RouterVo> findUserMenuListByUserId(Long userId) {
        List<SysMenu> sysMenuList = null;
        //判断当前用户是否是管理员 userId=1是管理员、
        if(userId.longValue()==1){
            //如果是管理员查询所有菜单列表
            LambdaQueryWrapper<SysMenu> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(SysMenu::getStatus,1);
            wrapper.orderByAsc(SysMenu::getSortValue);
            sysMenuList = baseMapper.selectList(wrapper);
        }else {
            //如果不是管理员，根据userId查询可以操作的菜单列表
            sysMenuList = baseMapper.findMenuListByUserId(userId);
        }
        //把查询出来的数据列表构建成框架要求的路由数据结构
        List<SysMenu> sysMenuTreeList = MenuHelper.buildTree(sysMenuList);
        List<RouterVo> routerList = this.buildRouter(sysMenuTreeList);
        return routerList;
    }

    private List<RouterVo> buildRouter(List<SysMenu> menus) {
        List<RouterVo> routers = new ArrayList<>();
        for (SysMenu sysMenu:menus){
            RouterVo routerVo = new RouterVo();
            routerVo.setHidden(false);
            routerVo.setAlwaysShow(false);
            routerVo.setPath(getRouterPath(sysMenu));
            routerVo.setComponent(sysMenu.getComponent());
            routerVo.setMeta(new MetaVo(sysMenu.getName(),sysMenu.getIcon()));
            //下一层数据
            List<SysMenu> children = sysMenu.getChildren();
            if(sysMenu.getType().intValue()==1){
                //加载出来下面的隐藏路由
                List<SysMenu> hiddenMenuList = children.stream().filter(item -> !StringUtils.isEmpty(item.getComponent())).collect(Collectors.toList());
                for (SysMenu menu:hiddenMenuList){
                    RouterVo hiddenRouter = new RouterVo();
                    hiddenRouter.setHidden(true);
                    hiddenRouter.setAlwaysShow(false);
                    hiddenRouter.setPath(getRouterPath(menu));
                    hiddenRouter.setComponent(menu.getComponent());
                    hiddenRouter.setMeta(new MetaVo(menu.getName(),menu.getIcon()));
                    routers.add(hiddenRouter);
                }
            }else {
                if(!CollectionUtils.isEmpty(children)){
                    if(children.size() > 0) {
                        routerVo.setAlwaysShow(true);
                    }
                    //递归
                    routerVo.setChildren(buildRouter(children));
                }
            }
            routers.add(routerVo);
        }
        return routers;
    }

    /**
     * 获取路由地址
     *
     * @param menu 菜单信息
     * @return 路由地址
     */
    public String getRouterPath(SysMenu menu) {
        String routerPath = "/" + menu.getPath();
        if(menu.getParentId().intValue() != 0) {
            routerPath = menu.getPath();
        }
        return routerPath;
    }
    @Override
    public List<String> findUserPermsByUserId(Long userId) {
        //判断当前用户是否是管理员 userId=1是管理员
        List<SysMenu> sysMenuList = null;
        if(userId.longValue()==1){
            //如果是管理员查询所有按钮列表
            LambdaQueryWrapper<SysMenu> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(SysMenu::getStatus,1);
            sysMenuList = baseMapper.selectList(wrapper);
        }else {
            //如果不是管理员，根据userId查询可以操作的按钮列表
            sysMenuList = baseMapper.findMenuListByUserId(userId);
        }
        //从查询出来的数据里面，获取可以操作按钮值的list集合，返回
        List<String> permsList = sysMenuList.stream().filter(item -> item.getType()==2).map(item -> item.getPerms()).collect(Collectors.toList());
        return permsList;
    }
}
