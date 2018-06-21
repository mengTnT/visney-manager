package com.tthome.visneymanager.controller;

import com.tthome.visneymanager.entity.ArticleEditor;
import com.tthome.visneymanager.service.ArticleEditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author zcy
 * @date 2018-05-31 18:59
 */
@RestController
@RequestMapping("articleEditor")
public class ArticleEditorController {
    @Autowired
    private ArticleEditorService articleEditorService;

    @PostMapping("/getArticleAllByPage")
    public Map getArticleAllByPage(int page, int rows) {
        return articleEditorService.getArticleAllByPage(page, rows);
    }
    @PostMapping("/getAllArticleEditor")
    public Map GetAllArticleEditor() {
        return articleEditorService.getArticleAll();
    }

    @PostMapping("/addArticleEditor")
    public Map addArticleEditor(ArticleEditor articleEditor) {
        return articleEditorService.editorAdd(articleEditor);
    }

    @PostMapping("/updateArticleEditor")
    public Map updateArticleEditor(ArticleEditor articleEditor) {
        return articleEditorService.editorUpdate(articleEditor);
    }

    @PostMapping("/deleteArticleEditor")
    public Map deleteArticleEditor(int[] ids) {
        return articleEditorService.editorDelte(ids);
    }

}
