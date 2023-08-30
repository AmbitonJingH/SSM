package com.atguigu.controller;
/*
 * @author  AmbitionJingH
 * @date  2023/8/30 23:04
 * @version 1.0
 */

import com.atguigu.dao.EmployeeDao;
import com.atguigu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/*
* 查询所有员工信息-->/employee-->get
* 跳转到添加页面-->/to/add-->get
* 新增员工信息-->/employee-->post
* 跳转到修改页面-->/employee/1-->get
* 修改员工信息-->/employee-->put
* 删除员工信息-->/employee/1-->delete
*
* */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee")
    public String getAllUser(Model model){
        Collection<Employee> list = employeeDao.getAll();
        model.addAttribute("allEmployee",list);
        list.forEach(System.out::println);
        return "employee_list";
    }
}
