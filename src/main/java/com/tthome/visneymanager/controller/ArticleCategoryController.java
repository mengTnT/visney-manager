package com.tthome.visneymanager.controller;

import com.tthome.visneymanager.entity.ArticleCategory;
import com.tthome.visneymanager.service.ArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author NBUG
 * @date 2018/5/11 17:31
 */
@RestController
@RequestMapping("/articleCategory")
public class ArticleCategoryController {
    @Autowired
    private ArticleCategoryService articleCategoryService;

    @GetMapping("/getAll")
    public List<ArticleCategory> getAllArticleCategory() {
        return articleCategoryService.getAllArticleCategory();
    }
    @PostMapping("/getAllpageArticleCategory")
    public Map getAllpageArticleCategory(int page,int rows){

        return articleCategoryService.getPageArticleCategory(page,rows);
    }
    @PostMapping("/addArticleCategory")
    public Map addArticleCategory(ArticleCategory articleCategory){

       return articleCategoryService.addArticleCategory(articleCategory);

    }
    @PostMapping("/deleteArticleCategory")
    public Map deleteArticleCategory(int [] articleCategoryId){
        return articleCategoryService.deleteArticleCategory(articleCategoryId);

    }
    @PostMapping("/updateArticleCategory")
    public Map updateArticleCategory(ArticleCategory articleCategory){
        return articleCategoryService.updateArticleCategory(articleCategory);
    }
}
