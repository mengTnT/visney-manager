package com.tthome.visneymanager.service;

import com.tthome.visneymanager.entity.ArticleEditor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zcy
 * @date 2018-05-31 18:30
 */
public interface ArticleEditorService {

    public Map getArticleAllByPage(int pageIndex,  int pagesize);
    public Map getArticleAll();
    public Map editorUpdate(ArticleEditor articleEditor);
    public Map editorDelte(int[] articleEditorId);
    public Map editorAdd(ArticleEditor articleEditor);

}
