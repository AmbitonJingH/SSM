package com.atguigu.spring6.tx.dao;
/*
 * @author  AmbitionJingH
 * @date  2023/8/19 17:37
 * @version 1.0
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Integer getBookPriceById(Integer bookId) {
        String sql = "select price from t_book where book_id=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,bookId);
    }

    @Override
    public void updateStock(Integer bookId) {
        String sql = "update t_book set stock = stock-1 where book_id=?";
        jdbcTemplate.update(sql,bookId);
    }

    @Override
    public void updateUserBalance(Integer userId, Integer price) {
        String sql = "update t_user set balance = balance-? where user_id=?";
        jdbcTemplate.update(sql,price,userId);
    }
}
