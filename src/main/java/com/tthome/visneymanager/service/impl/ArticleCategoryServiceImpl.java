package com.tthome.visneymanager.service.impl;

import com.tthome.visneymanager.dao.ArticleCategoryDao;
import com.tthome.visneymanager.entity.ArticleCategory;
import com.tthome.visneymanager.service.ArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author NBUG
 * @date 2018/5/11 17:12
 */
@Service
@Transactional


public class ArticleCategoryServiceImpl implements ArticleCategoryService {
    @Autowired
    private ArticleCategoryDao articleCategoryDao;
    @Override
    public List<ArticleCategory> getAllArticleCategory() {
        return articleCategoryDao.getAllArticleCategory();
    }

    @Override
    public Map getPageArticleCategory(int pageIndex, int pageSize) {
        Map map=new HashMap();
        int start=(pageIndex-1)*pageSize;
        int end=pageSize;
        List<ArticleCategory> pageArticleCategory = articleCategoryDao.getPageArticleCategory(start, end);

        int i=articleCategoryDao.getAllArticleCategoryCount();
        map.put("total",i);
        map.put("rows",pageArticleCategory);

        return map;
    }
    @Override
    public Map addArticleCategory(ArticleCategory articleCategory) {
        Map map=new HashMap();
        int i = articleCategoryDao.addArticleCategory(articleCategory);
        if(i>0){
            map.put("msg",true);
        }else{
            map.put("msg",false);
        }
        return map;
    }

    @Override
    public Map updateArticleCategory(ArticleCategory articleCategory) {
        Map map=new HashMap();
        int i = articleCategoryDao.updateArticleCategory(articleCategory);
        if(i>0){
            map.put("msg",true);
        }else{
            map.put("msg",false);
        }
        return map;
    }

    @Override
    public Map deleteArticleCategory(int[] articleCategoryId) {
        Map map=new HashMap();
        int i = articleCategoryDao.deleteArticleCategory(articleCategoryId);
        if(i>0){
            map.put("msg",true);
        }else{
            map.put("msg",false);
        }
        return map;
    }
}
