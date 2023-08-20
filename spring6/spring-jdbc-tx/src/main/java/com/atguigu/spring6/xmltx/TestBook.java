package com.atguigu.spring6.xmltx;

import com.atguigu.spring6.xmltx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/*
 * @author  AmbitionJingH
 * @date  2023/8/19 17:56
 * @version 1.0
 */
@SpringJUnitConfig(locations = "classpath:beans-xml.xml")
public class TestBook {
    @Autowired
    private BookController bookController;
//    @Test
//    public void test(){
//        bookController.buyBook(1,1);
//
//    }


    @Test
    public void test1(){
        Integer bookId = 1;
        bookController.buyBook(bookId,1);
    }
}
