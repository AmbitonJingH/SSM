package com.atguigu.spring6.tx.controller;

import com.atguigu.spring6.tx.service.BookService;
import com.atguigu.spring6.tx.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

/*
 * @author  AmbitionJingH
 * @date  2023/8/19 17:37
 * @version 1.0
 */
@Controller
public class BookController {
//    @Autowired
//    private BookService bookService;
//    public void buyBook(Integer bookId,Integer userId){
//        bookService.buyBook(bookId,userId);
//    }
    @Autowired
    private CheckOutService checkOutService;
    public void checkOut(Integer[] bookIds,Integer userId){
        checkOutService.checkou(bookIds, userId);
    }


}
