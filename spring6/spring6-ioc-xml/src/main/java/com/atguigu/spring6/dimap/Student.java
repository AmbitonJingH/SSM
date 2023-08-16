package com.atguigu.spring6.dimap;
/*
 * @author  AmbitionJingH
 * @date  2023/8/16 12:04
 * @version 1.0
 */

import java.util.List;
import java.util.Map;

public class Student {
    private Map<String,Teacher> teacherMap;
    private List<Lesson> lessonList;

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    private String sid;
    private String sname;
    public void run(){
        System.out.println("sid = " + sid+"  sname = "+sname);
        System.out.println(teacherMap);
        System.out.println(lessonList);
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
