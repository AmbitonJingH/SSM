package com.cf.boke.contorller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cf.boke.entity.Article;
import com.cf.boke.entity.Collect;
import com.cf.boke.entity.User;
import com.cf.boke.result.Result;
import com.cf.boke.service.ArticleService;
import com.cf.boke.service.CollectService;
import com.cf.boke.service.UserService;
import com.cf.boke.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * @author  AmbitionJingH
 * @date  2023/12/1 20:07
 * @version 1.0
 */
@RestController
@RequestMapping("/boke/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CollectService collectService;
    @RequestMapping("update")
    public Result update(@RequestBody User tempUser){
        boolean updated = userService.updateById(tempUser);
        if (updated){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    @RequestMapping("getDetail/{articleId}")
    public Result getDetail(@PathVariable Integer articleId){
        Article article = articleService.getById(articleId);
        User user = userService.getById(article.getUserId());
        return Result.ok(user);
    }

    //收藏文章
    @RequestMapping("collect/{articleId}")
    public Result collect(@PathVariable Integer articleId){
        Integer userId = Integer.parseInt(TokenUtils.getUserId());
        Collect collect = new Collect();
        collect.setUserId(userId);
        collect.setArticleId(articleId);
        collectService.save(collect);
        return Result.ok();
    }

    //取消收藏文章
    @RequestMapping("disCollect/{articleId}")
    public Result disCollect(@PathVariable Integer articleId){
        Integer userId = Integer.parseInt(TokenUtils.getUserId());
        LambdaQueryWrapper<Collect> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Collect::getUserId,userId).eq(Collect::getArticleId,articleId);
        collectService.remove(wrapper);
        return Result.ok();
    }
}
