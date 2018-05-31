package com.tthome.visneymanager.service.impl;

import com.tthome.visneymanager.dao.ArticleCategoryDao;
import com.tthome.visneymanager.entity.ArticleCategory;
import com.tthome.visneymanager.service.ArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author NBUG
 * @date 2018/5/11 17:12
 */
@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {
    @Autowired
    private ArticleCategoryDao articleCategoryDao;
    @Override
    public List<ArticleCategory> getAllArticleCategory() {
        return articleCategoryDao.getAllArticleCategory();
    }
}
