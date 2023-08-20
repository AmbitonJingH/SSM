package com.atguigu.spring6.resource;
/*
 * @author  AmbitionJingH
 * @date  2023/8/20 11:38
 * @version 1.0
 */

import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;

//演示UrlResourceDemo访问网络资源
public class UrlResourceDemo {
    //访问前缀http,file
    public static void loadUrlResource(String path){
        try {
            //创建Resource接口实现类
            UrlResource urlResource = new UrlResource(path);
            //获取资源信息
            System.out.println(urlResource.getFilename());
            System.out.println(urlResource.getURL());
            System.out.println(urlResource.getDescription());
            System.out.println(urlResource.getInputStream().read());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        String path = "http://www.baidu.com";
        loadUrlResource(path);
        loadUrlResource("file:atguigu.txt");
    }
}
