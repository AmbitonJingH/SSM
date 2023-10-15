package com.ambitionjh.auth.controller;
/*
 * @author  AmbitionJingH
 * @date  2023/9/26 11:31
 * @version 1.0
 */

import com.ambitionjh.auth.service.SysMenuService;
import com.ambitionjh.auth.service.SysUserService;
import com.ambitionjh.common.config.exception.GuiguException;
import com.ambitionjh.common.jwt.JwtHelper;
import com.ambitionjh.common.result.Result;
import com.ambitionjh.common.utils.MD5;
import com.ambitionjh.model.system.SysMenu;
import com.ambitionjh.model.system.SysUser;
import com.ambitionjh.vo.system.LoginVo;
import com.ambitionjh.vo.system.RouterVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "后台管理登录")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysMenuService sysMenuService;
    //login
    @PostMapping("login")
    public Result login(@RequestBody LoginVo loginVo){
//        Map<String, Object> map = new HashMap<>();
//        map.put("token","admin-token");
//        return Result.ok(map);
        String username = loginVo.getUsername();
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername,username);
        SysUser sysUser = sysUserService.getOne(wrapper);

        if(sysUser==null){
            throw new GuiguException(201,"用户不存在");
        }
        //判断密码
        //数据库存储密码(MD5)
        String password_db = sysUser.getPassword();
        //获取输入的密码
        String password_input = MD5.encrypt(loginVo.getPassword());
        if(!password_db.equals(password_input)){
            throw new GuiguException(201,"密码错误");
        }
        //判断用户是否被禁用
        if(sysUser.getStatus().intValue()==0){
            throw new GuiguException(201,"用户已经被禁用");
        }
        //使用jwt根据用户id和用户名生成token字符串
        String token = JwtHelper.createToken(sysUser.getId(), sysUser.getUsername());
        Map<String, Object> map = new HashMap<>();
        map.put("token",token);
        return Result.ok(map);

    }
    //info
    @GetMapping("info")
    public Result info(HttpServletRequest request){
        //获取请求头token字符串
        String token = request.getHeader("token");
        //从token字符串中获取用户id或用户名称
        Long userId = JwtHelper.getUserId(token);
        //根据用户id查询数据库，不用户信息获取出来
        SysUser sysUser = sysUserService.getById(userId);
        //根据用户id获取用户可以操作的菜单列表
        List<RouterVo> routerList = sysMenuService.findUserMenuListByUserId(userId);
        //根据用户id获取用户可以操作的按钮列表
        List<String> permsList = sysMenuService.findUserPermsByUserId(userId);
        Map<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("name",sysUser.getName());
        map.put("avatar","https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
        //返回用户可以操作的菜单
        map.put("routers",routerList);
        //返回用户可以操作的按钮
        map.put("buttons",permsList);
        return Result.ok(map);
    }

    @PostMapping("logout")
    public Result logout(){
        return Result.ok();
    }
}
