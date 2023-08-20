package com.atguigu.spring6.xmltx.service;
/*
 * @author  AmbitionJingH
 * @date  2023/8/20 9:48
 * @version 1.0
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckOutServiceImpl implements CheckOutService {
    @Autowired
    private BookService bookService;
    @Override
    @Transactional
    public void checkou(Integer[] bookIds, Integer userId) {
        for(Integer bookId : bookIds){
            bookService.buyBook(bookId,userId);
        }
    }
}
