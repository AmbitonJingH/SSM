package com.atguigu.spring6.diTest;
/*
 * @author  AmbitionJingH
 * @date  2023/8/16 9:12
 * @version 1.0
 */

import java.util.Arrays;

public class Emp {
    //员工属于某个部门
    private Dept dept;
    private String ename;
    private Integer age;
    private String[] hobbies;

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public void work(){
        System.out.println("员工:"+ename+"年龄:"+age+" 在工作...");
        System.out.println("爱好 : "+Arrays.toString(hobbies));
        dept.info();
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                ", ename='" + ename + '\'' +
                ", age=" + age +
                ", hobbies=" + Arrays.toString(hobbies) +
                '}';
    }
}
