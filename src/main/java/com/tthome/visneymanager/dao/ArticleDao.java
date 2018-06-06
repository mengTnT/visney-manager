package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.Article;
import com.tthome.visneymanager.vo.ArticleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author NBUG
 * @date 2018/5/14 9:25
 */
public interface ArticleDao {

    public Article getArticleDetails(int articleId);
    public List<Article> getArticles(@Param("category")String category,@Param("editor")String editor,@Param("title")String title);
    public List<Article> getArticlesByCategory(@Param("articleCategoryId") int articleCategoryId);



    /**
     * 文章分类别统计总数
     * @param articleCategoryId
     * @return
     */
    public int getTotalByArticleCategoryId(int articleCategoryId);

    public int getArticleTotal();

    public int articleDelete(int[] articleIds);

    public int articleAdd(Article article);


}
