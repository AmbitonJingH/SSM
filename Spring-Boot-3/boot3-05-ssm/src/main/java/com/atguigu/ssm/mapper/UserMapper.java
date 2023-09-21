package com.atguigu.ssm.mapper;
/*
 * @author  AmbitionJingH
 * @date  2023/9/21 23:40
 * @version 1.0
 */

import com.atguigu.ssm.bean.TUser;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public TUser getUserById(@Param("id") Long id);
}
