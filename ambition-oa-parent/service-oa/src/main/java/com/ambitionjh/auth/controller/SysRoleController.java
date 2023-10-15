package com.ambitionjh.auth.controller;
/*
 * @author  AmbitionJingH
 * @date  2023/9/24 17:55
 * @version 1.0
 */

import com.ambitionjh.auth.service.SysRoleService;
import com.ambitionjh.common.config.exception.GuiguException;
import com.ambitionjh.common.result.Result;
import com.ambitionjh.model.system.SysRole;
import com.ambitionjh.vo.system.AssginRoleVo;
import com.ambitionjh.vo.system.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {
    //注入service
    @Autowired
    private SysRoleService sysRoleService;

    //查询所有角色
//    @GetMapping("/findAll")
//    public List<SysRole> findAll(){
//        List<SysRole> roleList = sysRoleService.list();
//        return roleList;
//    }

    //返回统一的数据结果
    @ApiOperation("查询所有角色")
    @GetMapping("/findAll")
    public Result findAll(){
        List<SysRole> roleList = sysRoleService.list();
//        try {
//            int i = 10/0;
//        } catch (Exception e) {
//            throw new GuiguException(20001,"执行了自定义的异常处理");
//        }
        return Result.ok(roleList);
    }

    //条件分页查询
    //page 当前页  limit 每页显示记录数
    //SysRoleQueryVo 条件对象
    @PreAuthorize("hasAuthority('bnt.sysRole.list')")
    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result pageQueryRole(@PathVariable Long page,
                                @PathVariable Long limit,
                                SysRoleQueryVo sysRoleQueryVo){
        //调用service的方法实现
        //1 创建Page对象，传递分页相关参数
        Page<SysRole> PageParam = new Page<>(page,limit);
        //page 当前页  limit 每页显示记录数
        //2 封装条件，判断条件是否为空，不为空进行封装
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        String roleName = sysRoleQueryVo.getRoleName();
        if(!StringUtils.isEmpty(roleName)){
            wrapper.like(SysRole::getRoleName,roleName);

        }
        IPage<SysRole> pageModel = sysRoleService.page(PageParam, wrapper);
        //3 调用方法实现
        return Result.ok(pageModel);
    }

    //添加角色
    @PreAuthorize("hasAuthority('bnt.sysRole.add')")
    @ApiOperation("添加角色")
    @PostMapping("save")
    public Result save(@RequestBody SysRole role){
        //调用service的方法
        boolean saved = sysRoleService.save(role);
        if(saved){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    //修改角色-根据id查询
    @PreAuthorize("hasAuthority('bnt.sysRole.list')")
    @ApiOperation("根据id查询")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id){
        SysRole role = sysRoleService.getById(id);
        return Result.ok(role);
    }

    //修改角色-最终修改
    @PreAuthorize("hasAuthority('bnt.sysRole.update')")
    @ApiOperation("修改角色")
    @PutMapping("update")
    public Result update(@RequestBody SysRole role){
        //调用service的方法
        boolean saved = sysRoleService.updateById(role);
        if(saved){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    //根据id删除
    @PreAuthorize("hasAuthority('bnt.sysRole.remove')")
    @ApiOperation("根据id删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id){
        boolean removed = sysRoleService.removeById(id);
        if(removed){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }
    //批量删除
    @PreAuthorize("hasAuthority('bnt.sysRole.remove')")
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList){
        boolean removed = sysRoleService.removeByIds(idList);
        if(removed){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    //============================sys_user_role表的操作===============================
    //1、查询所有角色和当前用户所属角色
    @ApiOperation("获取角色")
    @GetMapping("/toAssign/{userId}")
    public Result toAssign(@PathVariable("userId") Long userId){
       Map<String,Object> map = sysRoleService.findRoleDataByUserId(userId);
       //System.out.println(map);
       return Result.ok(map);
    }
    //2、为用户分配角色
    @ApiOperation("为用户分配角色")
    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssginRoleVo assginRoleVo){
        sysRoleService.doAssign(assginRoleVo);
        return Result.ok();
    }
}
