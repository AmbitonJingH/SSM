package com.atguigu.mybatis.mapper;
/*
 * @author  AmbitionJingH
 * @date  2023/8/23 22:02
 * @version 1.0
 */

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {
    Emp getEmpById(@Param("empId")Integer empId);
    void insertEmp(Emp emp);
}
