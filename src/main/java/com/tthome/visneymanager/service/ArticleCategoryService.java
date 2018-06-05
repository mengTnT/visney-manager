package com.tthome.visneymanager.service;

import com.tthome.visneymanager.entity.ArticleCategory;

import java.util.List;
import java.util.Map;

/**
 * @author NBUG
 * @date 2018/5/11 17:10
 */
public interface ArticleCategoryService {
    public List<ArticleCategory> getAllArticleCategory();
    public Map getPageArticleCategory(int pageIndex, int pageSize);
    public Map  addArticleCategory(ArticleCategory articleCategory);
    public Map updateArticleCategory(ArticleCategory articleCategory);
    public Map deleteArticleCategory(int[] articleCategoryId);
}
