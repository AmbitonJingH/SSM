package com.atguigu.spring6.resource;
/*
 * @author  AmbitionJingH
 * @date  2023/8/20 11:50
 * @version 1.0
 */

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

//访问类路径下的资源
public class ClassPathDemo {
    public static void load(String path){
        ClassPathResource classPathResource = new ClassPathResource(path);
        System.out.println(classPathResource.getFilename());
        System.out.println(classPathResource.getDescription());
        try {
            InputStream is = classPathResource.getInputStream();
            byte[] buffer = new byte[20];
            int len = -1;
            while (is.read(buffer)!=len){
                System.out.println(new String(buffer));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        load("atguigu.txt");
    }
}
