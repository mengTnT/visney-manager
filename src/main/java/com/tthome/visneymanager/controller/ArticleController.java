package com.tthome.visneymanager.controller;


import com.tthome.visneymanager.entity.Article;
import com.tthome.visneymanager.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author NBUG
 * @date 2018/5/14 9:26
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;



    @GetMapping("/getArticleDetails/{articleId}")
    public Article getArticleDetails(@PathVariable("articleId") int articleId) {

        return articleService.getArticleDetails(articleId);
    }

    @RequestMapping("/getArticlesByCategory")
    public Map getArticles(int articleCategoryId, int page, int rows) {

        return articleService.getArticles(articleCategoryId,page,rows);
    }
    @RequestMapping("/getArticles")
    public Map getArticles(int page, int rows){
        return  articleService.getArticles(page,rows);
    }
    @RequestMapping("/articleDelete")
    public int articleDelete(int[] articleIds,int[]pageViewsIds,int []articleImgIds){
        return articleService.articleDelete(articleIds, pageViewsIds, articleImgIds);

    }



}
