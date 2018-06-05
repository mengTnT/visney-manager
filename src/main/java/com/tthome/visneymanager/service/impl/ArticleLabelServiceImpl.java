package com.tthome.visneymanager.service.impl;

import com.tthome.visneymanager.dao.ArticleLabelDao;
import com.tthome.visneymanager.entity.ArticleLabel;
import com.tthome.visneymanager.service.ArticleLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author NBUG
 * @date 2018/5/30 16:09
 */
@Service
@Transactional
public class ArticleLabelServiceImpl implements ArticleLabelService {
    @Autowired
    private ArticleLabelDao articleLabelDao;
    @Override
    public int articleLabelDelete(int[] articleIds) {
        return articleLabelDao.articleLabelDelete(articleIds);
    }

    @Override
    public Map getAllArticleLabel(int pageIndex, int pageSize) {
        Map map=new HashMap();
        int start=(pageIndex-1)*pageSize;
        int end=pageSize;
        List<ArticleLabel> allArticleLabel = articleLabelDao.getAllArticleLabel(start, end);
        int i = articleLabelDao.getAllArticleLabelCount();
        map.put("total",i);
        map.put("rows",allArticleLabel);
        return map;
    }

    @Override
    public Map addArticleLabel(ArticleLabel articleLabel) {
        Map map=new HashMap();
        int i = articleLabelDao.addArticleLabel(articleLabel);
        if(i==1){
            map.put("msg",true);
        }else {
            map.put("msg",false);
        }
        return map;
    }

    @Override
    public Map updateArticleLabel(ArticleLabel articleLabel) {
        Map map=new HashMap();
        int i = articleLabelDao.updateArticleLabel(articleLabel);
        if(i==1){
            map.put("msg",true);
        }else {
            map.put("msg",false);
        }
        return map;
    }
}
