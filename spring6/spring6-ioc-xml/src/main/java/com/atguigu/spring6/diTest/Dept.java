package com.atguigu.spring6.diTest;
/*
 * @author  AmbitionJingH
 * @date  2023/8/16 9:12
 * @version 1.0
 */

import java.util.List;

public class Dept {
    private List<Emp> empList;
    private String dname;

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void info(){
        System.out.println("dname = " + dname);
        for(Emp emp:empList){
            System.out.println(emp);
        }
    }
}
