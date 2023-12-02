package com.cf.boke.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cf.boke.entity.Article;
import com.cf.boke.entity.ArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;


public interface ArticleMapper extends BaseMapper<Article> {
    long countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Article row);

    int insertSelective(Article row);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Article row, @Param("example") ArticleExample example);

    int updateByExample(@Param("row") Article row, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article row);

    int updateByPrimaryKey(Article row);
}