package com.tthome.visneymanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.tthome.visneymanager.dao.ArticleDao;
import com.tthome.visneymanager.dao.ArticleImgDao;
import com.tthome.visneymanager.dao.ArticleLabelDao;
import com.tthome.visneymanager.dao.PageViewsDao;
import com.tthome.visneymanager.entity.Article;
import com.tthome.visneymanager.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author NBUG
 * @date 2018/5/14 9:24
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ArticleLabelDao articleLabelDao;
    @Autowired
    private ArticleImgDao articleImgDao;
    @Autowired
    private PageViewsDao pageViewsDao;


    @Override
    public Article getArticleDetails(int articleId) {
        return articleDao.getArticleDetails(articleId);
    }

    @Override
    public Map getArticles(int articleCategoryId, int page, int rows) {
            Map map = new HashMap();
            int total = articleDao.getTotalByArticleCategoryId(articleCategoryId);
            PageHelper.startPage(page, rows);
            List<Article> list = articleDao.getArticlesByCategory(articleCategoryId);
            map.put("total", total);
            map.put("rows", list);
            return map;
    }

    @Override
    public Map getArticles(int page, int rows,String category,String editor,String title) {
        Map map = new HashMap();
        int total = articleDao.getArticleTotal();
        PageHelper.startPage(page, rows);
        List<Article> list = articleDao.getArticles(category, editor, title);
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @Override
    public int articleDelete(int[] articleIds, int[] pageViewsIds, int[] articleImgIds) {
        int articleLabelDelete = articleLabelDao.articleLabelDelete(articleIds);

        int articleDelete = articleDao.articleDelete(articleIds);

        int pageViewsDelete = pageViewsDao.pageViewsDelete(pageViewsIds);

        int articleImgDelete = articleImgDao.articleImgDelete(articleImgIds);
        if (articleLabelDelete!=0&&articleDelete!=0&&pageViewsDelete!=0&&articleImgDelete!=0){
            return 1;
        }
        return 0;
    }


}
