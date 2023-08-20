package com.atguigu.spring6.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/*
 * @author  AmbitionJingH
 * @date  2023/8/19 16:49
 * @version 1.0
 */
@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JDBCTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //查询：返回对象
    @Test
    public void testSelectObject(){
        String sql = "select * from t_emp where id=?";
        //写法1
//        Emp emp = jdbcTemplate.queryForObject(sql, ((rs, rowNum) -> {
//            Emp temp = new Emp();
//            temp.setId(rs.getInt("id"));
//            temp.setName(rs.getString("name"));
//            temp.setAge(rs.getInt("age"));
//            temp.setSex(rs.getString("sex"));
//            return temp;
//        }), 2);
//        System.out.println("emp = " + emp);

        //写法二
        Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 1);
        System.out.println("emp = " + emp);
    }

    //查询 返回集合
    @Test
    public void testSelectList(){
        String sql = "select * from t_emp where sex=?";
        List<Emp> empList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class), "女");
        for(Emp emp : empList){
            System.out.println("emp = " + emp);
        }
    }

    //查询 返回单个值
    @Test
    public void testSelectValue(){
        String sql = "select count(*) from t_emp";
        Integer values = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("values = " + values);
    }


    //更新
    @Test
    public void testUpdate(){
        //添加操作
//        String sql = "insert into t_emp values(0,?,?,?)";
//        int rows = jdbcTemplate.update(sql, "王五", 35, "男");
//        System.out.println("rows = " + rows);
        //修改
//        String sql = "update t_emp set sex=? where name=?";
//        int rows = jdbcTemplate.update(sql, "女", "张三");
//        System.out.println("rows = " + rows);
        //删除
        String sql = "delete from t_emp where id =?";
        int rows = jdbcTemplate.update(sql, 3);
        System.out.println("rows = " + rows);
    }
}
