package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.ArticleLabel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author NBUG
 * @date 2018/5/30 16:10
 */
public interface ArticleLabelDao {
    public int articleLabelDelete(int[] articleIds);

    public List<ArticleLabel> getAllArticleLabelByPage(@Param("start") int start,@Param("end") int end);
    public List<ArticleLabel> getAllArticleLabel();
    public int getAllArticleLabelCount();

    public int addArticleLabel(ArticleLabel articleLabel);
    public int updateArticleLabel(ArticleLabel articleLabel);

}
