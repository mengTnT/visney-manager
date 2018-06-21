package com.tthome.visneymanager.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tthome.visneymanager.dao.ArticleDao;
import com.tthome.visneymanager.dao.ArticleImgDao;
import com.tthome.visneymanager.dao.ArticleLabelDao;
import com.tthome.visneymanager.dao.PageViewsDao;
import com.tthome.visneymanager.entity.Article;
import com.tthome.visneymanager.entity.ArticleImg;
import com.tthome.visneymanager.entity.ArticleLabel;
import com.tthome.visneymanager.entity.PageViews;
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
        /*int total = articleDao.getArticleTotal(category, editor, title);*/
        PageHelper.startPage(page, rows);
        List<Article> list = articleDao.getArticles(category, editor, title);
        map.put("total", list.size());
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

    @Override
    public int articleAdd(String label1,String label2,Article article) {
        ArticleImg articleImg = article.getArticleImg();
        //先添加浏览量，获取id
        PageViews pageViews=new PageViews();
        int pageViewsAdd = pageViewsDao.pageViewsAdd(pageViews);
        int pageViewsId = pageViews.getPageViewsId();
        //先添加图片，获取图片id
        int imgAdd = articleImgDao.articleImgAdd(articleImg);
        int articleImgId = articleImg.getArticleImgId();
        //后添加文章，获取文章id
        article.setPageViews(pageViews);
        articleImg.setArticleImgId(articleImgId);

        int articleAdd = articleDao.articleAdd(article);
        Integer articleId = article.getArticleId();
        //最后添加标签,填充文章的id
        //标签1
        ArticleLabel articleLabel1=new ArticleLabel();
        articleLabel1.setArticleLabelName(label1);
        articleLabel1.setArticleId(articleId);
        //标签2
        ArticleLabel articleLabel2=new ArticleLabel();
        articleLabel2.setArticleLabelName(label2);
        articleLabel2.setArticleId(articleId);
        //添加
        int addArticleLabel = articleLabelDao.addArticleLabel(articleLabel1);
        int addArticleLabel2 = articleLabelDao.addArticleLabel(articleLabel2);

        //所有的都添加成功，代表成功返回1
        if(pageViewsAdd==1&&imgAdd==1&&articleAdd==1&&addArticleLabel==1&&addArticleLabel2==1){
            return 1;
        }

        return 0;
    }

    @Override
    public int articleUpdate(int labelID1, int labelID2, String label1, String label2,Article article) {
        ArticleImg articleImg = article.getArticleImg();
        //修改标签1
        ArticleLabel articleLabel1=new ArticleLabel();
        articleLabel1.setArticleLabelId(labelID1);
        articleLabel1.setArticleLabelName(label1);
        //修改标签2
        ArticleLabel articleLabel2=new ArticleLabel();
        articleLabel2.setArticleLabelId(labelID2);
        articleLabel2.setArticleLabelName(label2);

        int updateArticleLabel1 = articleLabelDao.updateArticleLabel(articleLabel1);
        int updateArticleLabel2 = articleLabelDao.updateArticleLabel(articleLabel2);
        //修改图片
        int articleImgUpdate = articleImgDao.articleImgUpdate(articleImg);
        //修改文章
        int articleUpdate = articleDao.articleUpdate(article);

        if (updateArticleLabel1==1&&updateArticleLabel2==1&&articleImgUpdate==1&&articleImgUpdate==1){
            return 1;
        }
        return 0;
    }


}
