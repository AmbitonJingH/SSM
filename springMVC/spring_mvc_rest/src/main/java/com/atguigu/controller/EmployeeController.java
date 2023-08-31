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
import org.springframework.web.bind.annotation.*;

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

   @RequestMapping("/employee")
    public String addUser(Employee employee){
       System.out.println(employee);
        //保存员工信息
        employeeDao.save(employee);
        //重定向到列表功能
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    @PutMapping("/employee")
    public String updateUser(Employee employee){
        employeeDao.save(employee);
        return "redirect:employee";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        //删除员工信息
        employeeDao.delete(id);
        //重定向到列表功能：/employee
        return "redirect:/employee";
    }

}
