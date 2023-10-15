package com.ambitionjh.auth.utils;
/*
 * @author  AmbitionJingH
 * @date  2023/10/3 16:18
 * @version 1.0
 */

import com.ambitionjh.model.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

public class MenuHelper {
    //使用递归方法构建菜单
    public static List<SysMenu> buildTree(List<SysMenu> sysMenuList) {
        //1、创建list集合，用于最终数据
        List<SysMenu> trees = new ArrayList<>();
        for(SysMenu sysMenu:sysMenuList){
            //递归入口(parentId=0)
            if(sysMenu.getParentId().longValue()==0){
                trees.add(getChildren(sysMenu,sysMenuList));
            }
        }
        return trees;
    }

    public static SysMenu getChildren(SysMenu sysMenu,List<SysMenu> sysMenuList){
        sysMenu.setChildren(new ArrayList<SysMenu>());
        //遍历所有菜单数据，判断id和parentId对应关系
        for (SysMenu menu : sysMenuList) {
            if(sysMenu.getId().longValue()==menu.getParentId().longValue()){
                if(sysMenu.getChildren()==null){
                    sysMenu.setChildren(new ArrayList<>());
                }
                sysMenu.getChildren().add(getChildren(menu,sysMenuList));
            }
        }
        return sysMenu;
    }
}
