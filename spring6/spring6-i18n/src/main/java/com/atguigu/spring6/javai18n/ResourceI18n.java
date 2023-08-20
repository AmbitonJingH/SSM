package com.atguigu.spring6.javai18n;
/*
 * @author  AmbitionJingH
 * @date  2023/8/20 23:44
 * @version 1.0
 */

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceI18n {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("message", new Locale("zh", "CN"));
        String test = bundle.getString("test");
        System.out.println(test);

        ResourceBundle bundle1 = ResourceBundle.getBundle("message", new Locale("en", "GB"));
        String test1 = bundle1.getString("test");
        System.out.println(test1);
    }
}
