package com.tthome.visneymanager.service;

import com.tthome.visneymanager.entity.Article;
import com.tthome.visneymanager.entity.ArticleImg;

import java.util.List;
import java.util.Map;

/**
 * @author NBUG
 * @date 2018/5/14 9:04
 */
public interface ArticleService {


    /**
     * 获取文章详情
     * @param articleId
     * @return
     */
    public Article getArticleDetails(int articleId);

    /**
     * 根据文章类别获取全部文章,有分页操作
     * @param articleCategoryId
     * @return
     */
    public Map getArticles(int articleCategoryId, int page, int rows);

    /**
     * 获取所有文章,可分类查询
     * @param page
     * @param rows
     * @return
     */
    public Map getArticles(int page, int rows,String category,String editor,String title);

    public int articleDelete(int[] articleIds,int[]pageViewsIds,int []articleImgIds);

    public int articleAdd(String label1,String label2,Article article);



}
