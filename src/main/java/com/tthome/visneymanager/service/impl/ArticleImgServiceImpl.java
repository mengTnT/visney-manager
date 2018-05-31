package com.tthome.visneymanager.service.impl;

import com.tthome.visneymanager.dao.ArticleImgDao;
import com.tthome.visneymanager.service.ArticleImgService;
import com.tthome.visneymanager.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author NBUG
 * @date 2018/5/30 15:53
 */
@Service
@Transactional
public class ArticleImgServiceImpl implements ArticleImgService {
    @Autowired
    private ArticleImgDao articleImgDao;
    @Override
    public int articleImgDelete(int[] articleImgIds) {
        return articleImgDao.articleImgDelete(articleImgIds);
    }
}
