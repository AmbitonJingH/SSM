package com.atguigu.mybatis.mapper;
/*
 * @author  AmbitionJingH
 * @date  2023/8/23 15:18
 * @version 1.0
 */

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    //通过分步查询根据id查询员工和部门信息 第二步
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);
    //查询部门以及部门中的员工信息
    Dept getDeptAndEmpByDeptId(@Param("deptId")Integer deptId);
    //通过分步查询询部门以及部门中的员工信息 第一步
    Dept getDeptAndEmpByDeptIdStepOne(@Param("deptId")Integer deptId);
}
