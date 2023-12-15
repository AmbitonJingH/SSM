package com.cf.boke.contorller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cf.boke.entity.Article;
import com.cf.boke.entity.Collect;
import com.cf.boke.result.Result;
import com.cf.boke.service.ArticleService;
import com.cf.boke.service.CollectService;
import com.cf.boke.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
 * @author  AmbitionJingH
 * @date  2023/12/15 14:30
 * @version 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/boke/article")
public class CollectController {
    @Autowired
    private CollectService collectService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping("myCollections")
    public Result myCollections(){
        Integer userId = Integer.parseInt(TokenUtils.getUserId());
        LambdaQueryWrapper<Collect> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Collect::getUserId,userId);
        List<Collect> list = collectService.list(wrapper);
//        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
//        articleWrapper.eq(Article::getDeleted,0);
        List<Article> articleList = articleService.list();
        List<Article> myCollections = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Collect collect = list.get(i);
            Integer articleId = collect.getArticleId();
            for (int j = 0; j < articleList.size(); j++) {
                if(articleId == articleList.get(j).getId()){
                    myCollections.add(articleList.get(j));
                }
            }
        }
        return Result.ok(myCollections);
    }
}
