package com.atguigu.spring6.xmltx.service;

import com.atguigu.spring6.xmltx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 * @author  AmbitionJingH
 * @date  2023/8/19 17:37
 * @version 1.0
 */
//只读
//@Transactional(readOnly = true)
//超时
//@Transactional(timeout = 3) (timeout = -1)永不超时
//回滚策略
//@Transactional(noRollbackFor = ArithmeticException.class)//出现此异常不进行回滚

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(Integer bookId, Integer userId) {
        //根据图书id查询图书价格
        Integer price = bookDao.getBookPriceById(bookId);
        //对应的图书库存-1
        bookDao.updateStock(bookId);
        //对应的用户余额进行更新
        bookDao.updateUserBalance(userId,price);
        //System.out.println(1/0);
    }
}
