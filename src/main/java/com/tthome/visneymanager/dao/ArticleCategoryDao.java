package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.ArticleCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author NBUG
 * @date 2018/5/11 17:13
 */
public interface ArticleCategoryDao {
    public List<ArticleCategory> getAllArticleCategory();
    public List<ArticleCategory> getPageArticleCategory(@Param("start") int start,@Param("end") int end);
    public int getAllArticleCategoryCount();
    public int  addArticleCategory(ArticleCategory articleCategory);
    public int updateArticleCategory(ArticleCategory articleCategory);
    public int deleteArticleCategory(int[] articleCategoryId);

}
