package com.tthome.visneymanager.service.impl;

import com.tthome.visneymanager.dao.ArticleLabelDao;
import com.tthome.visneymanager.service.ArticleLabelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author NBUG
 * @date 2018/5/30 16:09
 */
@Service
@Transactional
public class ArticleLabelServiceImpl implements ArticleLabelService {
    private ArticleLabelDao articleLabelDao;
    @Override
    public int articleLabelDelete(int[] articleIds) {
        return articleLabelDao.articleLabelDelete(articleIds);
    }
}
