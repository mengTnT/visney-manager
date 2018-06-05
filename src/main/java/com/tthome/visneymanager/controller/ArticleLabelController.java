package com.tthome.visneymanager.controller;

import java.util.Map;
import com.tthome.visneymanager.entity.ArticleLabel;
import com.tthome.visneymanager.service.ArticleLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zcy
 * @date 2018-06-01 16:00
 */
@RestController
@RequestMapping("/articleLabel")
public class ArticleLabelController {
    @Autowired
    private ArticleLabelService articleLabelService;
    @PostMapping("/getAllArticleLabel")
    public Map getAllArticleLabel(int page,int rows){
        return articleLabelService.getAllArticleLabel(page,rows);
    }
    @PostMapping("/addArticleLabel")
    public Map addArticleLabel(ArticleLabel articleLabel){
        return articleLabelService.addArticleLabel(articleLabel);
    }
    @PostMapping("/updateArticleLabel")
    public Map updateArticleLabel(ArticleLabel articleLabel){
        return articleLabelService.updateArticleLabel(articleLabel);
    }
}
