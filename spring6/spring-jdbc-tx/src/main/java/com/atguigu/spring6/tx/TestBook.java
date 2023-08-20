package com.atguigu.spring6.tx;

import com.atguigu.spring6.tx.controller.BookController;
import com.atguigu.spring6.tx.service.CheckOutService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/*
 * @author  AmbitionJingH
 * @date  2023/8/19 17:56
 * @version 1.0
 */
@SpringJUnitConfig(locations = "classpath:beans.xml")
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
        Integer[] bookIds = {1,2};
        bookController.checkOut(bookIds,1);
    }
}
