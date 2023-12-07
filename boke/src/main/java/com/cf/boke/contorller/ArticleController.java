package com.cf.boke.contorller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cf.boke.entity.Article;
import com.cf.boke.entity.User;
import com.cf.boke.result.Result;
import com.cf.boke.service.ArticleService;
import com.cf.boke.service.UserService;
import com.cf.boke.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping("show")
    public Result showArticle(){
        List<Article> list = articleService.list();
        return Result.ok(list);
    }

    @RequestMapping("showOne/{id}")
    public Result showOneArticle(@PathVariable Integer id){
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Article::getId,id);
        Article article = articleService.getOne(wrapper);
        return Result.ok(article);
    }

    @RequestMapping("add")
    public Result addArticle(@RequestBody Article tempArticle){
        //TODO 加入作者的userId
        String userId = TokenUtils.getUserId();
        tempArticle.setUserId(Integer.valueOf(userId));
        articleService.save(tempArticle);
        return Result.ok();
    }

    @RequestMapping("remove/{id}")
    public Result removeArticle(@PathVariable Integer id){
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Article::getId,id);
        boolean removed = articleService.remove(wrapper);
        if(removed)
            return Result.ok();
        else
            return Result.fail();
    }
}
