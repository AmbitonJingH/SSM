package com.cf.boke.contorller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cf.boke.entity.Article;
import com.cf.boke.entity.Sorted;
import com.cf.boke.entity.User;
import com.cf.boke.result.Result;
import com.cf.boke.service.ArticleService;
import com.cf.boke.service.UserService;
import com.cf.boke.utils.TokenUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @author  AmbitionJingH
 * @date  2023/12/2 22:08
 * @version 1.0
 */
@RestController
@RequestMapping("/boke/article")
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;

    //展示所有文章
    @RequestMapping("show")
    public Result showArticle(){
        List<Article> list = articleService.list();
        return Result.ok(list);
    }

    //按照分类Id展示文章
    @RequestMapping("showSorted/{sortId}")
    public Result showSorted(@PathVariable Integer sortId){
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Article::getSortId,sortId);
        List<Article> list = articleService.list(wrapper);
        String sortedName = null;
        if(list.size()>0) {
            Article article = list.get(0);
            Integer sortId1 = article.getSortId();
            Sorted[] values = Sorted.values();
            for (int i = 0; i < values.length; i++) {
                if((sortId1+"").equals(values[i].getId())){
                    sortedName = values[i].getName();
                    break;
                }
            }
            Map<String, List> map = new HashMap<>();
            map.put(sortedName,list);
            return Result.ok(map);
        }
        return Result.fail();
    }

    //查看文章详细
    @RequestMapping("showOne/{id}")
    public Result showOneArticle(@PathVariable Integer id){
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Article::getId,id);
        Article article = articleService.getOne(wrapper);
        return Result.ok(article);
    }

    //发布文章
    @RequestMapping("add")
    public Result addArticle(@RequestBody Article tempArticle){
        //TODO 加入作者的userId
        String userId = TokenUtils.getUserId();
        tempArticle.setUserId(Integer.valueOf(userId));
        articleService.save(tempArticle);
        return Result.ok();
    }

    //删除文章
    @RequestMapping("remove/{id}")
    public Result removeArticle(@PathVariable Integer id){
//        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(Article::getId,id);
        boolean removed = articleService.removeById(id);
        //boolean removed = articleService.remove(wrapper);
        if(removed)
            return Result.ok();
        else
            return Result.fail();
    }
}
