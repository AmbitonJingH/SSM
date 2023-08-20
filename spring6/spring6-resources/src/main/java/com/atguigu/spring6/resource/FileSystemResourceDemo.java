package com.atguigu.spring6.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.InputStream;

/*
 * @author  AmbitionJingH
 * @date  2023/8/20 11:56
 * @version 1.0
 */
//访问系统中的资源
public class FileSystemResourceDemo {
    public static void load(String path){
        FileSystemResource resource = new FileSystemResource(path);
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
        try {
            InputStream is = resource.getInputStream();
            byte[] b = new byte[1024];
            int len = -1;
            while (is.read(b)!=len){
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        load("f:\\atguigu.txt");
    }
}
