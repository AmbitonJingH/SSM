package com.atguigu.spring6.life;
/*
 * @author  AmbitionJingH
 * @date  2023/8/16 18:59
 * @version 1.0
 */

public class User {
    private String name;

    public User(){
        System.out.println("1. 创建对象");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2. 设置属性值");
        this.name = name;
    }

    public void init(){
        System.out.println("4. 初始化");
    }

    public void destroy(){
        System.out.println("7. 销毁");
    }
}
