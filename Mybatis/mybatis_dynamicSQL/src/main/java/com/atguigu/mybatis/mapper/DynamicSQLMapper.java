package com.atguigu.mybatis.mapper;
/*
 * @author  AmbitionJingH
 * @date  2023/8/23 18:33
 * @version 1.0
 */

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    //根据条件查询员工信息
    List<Emp> getEmpByCondition(Emp emp);
    //使用choose来查询员工信息
    List<Emp> getEmpByChoose(Emp emp);
    //批量添加
    void insertMoreEmp(@Param("empList") List<Emp> empList);
    //批量删除
    void deleteMoreEmp(@Param("empIds") Integer[] empIds);
}
