package com.cf.boke.entity;
/*
 * @author  AmbitionJingH
 * @date  2023/12/11 19:01
 * @version 1.0
 */

public enum Sorted {
    JAVA("1","java"),
    C("2","c");
    private String id;
    private String name;
    Sorted(String id,String name){
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
