package com.atguigu.spring6.xmltx.dao;
/*
 * @author  AmbitionJingH
 * @date  2023/8/19 17:37
 * @version 1.0
 */



public interface BookDao {

    Integer getBookPriceById(Integer bookId);

    void updateStock(Integer bookId);

    void updateUserBalance(Integer userId, Integer price);
}
