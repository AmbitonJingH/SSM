package com.atguigu.spring6.dimap;
/*
 * @author  AmbitionJingH
 * @date  2023/8/16 12:04
 * @version 1.0
 */

import java.util.Map;

public class Teacher {

    private String tid;
    private String tname;

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
