package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.Article;
import com.tthome.visneymanager.entity.ArticleEditor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zcy
 * @date 2018-05-31 17:30
 */
public interface ArticleEditorDao {
    public List<ArticleEditor> getArticleAllByPage(@Param("start")int start,@Param("end") int end);
    public List<ArticleEditor> getArticleAll();
    public int getArticleEditorCount();
    public int editorUpdate(ArticleEditor articleEditor);
    public int editorDelte(int[] articleEditorId);
    public int editorAdd(ArticleEditor articleEditor);

}
