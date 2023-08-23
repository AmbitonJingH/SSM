package com.atguigu.mybatis.mapper;
/*
 * @author  AmbitionJingH
 * @date  2023/8/23 15:18
 * @version 1.0
 */

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    //根据id查询员工信息
    Emp getEmpByEmpId(@Param("empId") Integer empId);
    //根据id查询员工和部门信息
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);
    //通过分步查询根据id查询员工和部门信息 第一步
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);
    List<Emp> getEmpByDeptId(@Param("deptId") Integer deptId);
}
