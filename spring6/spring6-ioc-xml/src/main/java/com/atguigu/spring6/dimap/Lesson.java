package com.atguigu.spring6.dimap;
/*
 * @author  AmbitionJingH
 * @date  2023/8/16 12:33
 * @version 1.0
 */

public class Lesson {
    private String lname;

    @Override
    public String toString() {
        return "Lesson{" +
                "lname='" + lname + '\'' +
                '}';
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
