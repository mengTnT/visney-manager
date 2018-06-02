package com.tthome.visneymanager.service.impl;

import com.tthome.visneymanager.dao.ArticleEditorDao;
import com.tthome.visneymanager.entity.ArticleEditor;
import com.tthome.visneymanager.service.ArticleEditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zcy
 * @date 2018-05-31 18:31
 */
@Service
@Transactional
public class ArticleEditorServiceImpl implements ArticleEditorService {
    @Autowired
    private ArticleEditorDao articleEditorDao;


    @Override
    public Map  getArticleAll(int pageIndex, int pageSize) {
        int start=pageSize*(pageIndex-1);
        int end=pageSize;
        Map map=new HashMap();
        List<ArticleEditor> articleAll = articleEditorDao.getArticleAll(start, end);
        int i=articleEditorDao.getArticleEditorCount();
        map.put("total",i);//上传的总的条数
        map.put("rows",articleAll);//上传的内容
        return map;
    }

    @Override
    public Map editorUpdate(ArticleEditor articleEditor) {
        Map map=new HashMap();
        int i = articleEditorDao.editorUpdate(articleEditor);
        System.out.println(i+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        if(i==1){
            map.put("msg",true);
        }else{
            map.put("msg",false);
        }
        return map;
    }

    @Override
    public Map editorDelte(int[] articleEditorId) {
        Map map=new HashMap();
        int i = articleEditorDao.editorDelte(articleEditorId);
        if(i==1){
            map.put("msg",true);
        }else{
            map.put("msg",false);
        }
        return map;
    }

    @Override
    public Map editorAdd(ArticleEditor articleEditor) {
        Map map=new HashMap();
        int i = articleEditorDao.editorAdd(articleEditor);
        if(i==1){
            map.put("msg",true);
        }else{
            map.put("msg",false);
        }
        return map;
    }
}
