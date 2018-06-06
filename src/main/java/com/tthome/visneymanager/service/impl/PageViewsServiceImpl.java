package com.tthome.visneymanager.service.impl;

import com.tthome.visneymanager.dao.PageViewsDao;
import com.tthome.visneymanager.entity.PageViews;
import com.tthome.visneymanager.service.PageViewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author NBUG
 * @date 2018/5/30 15:44
 */
@Service
@Transactional
public class PageViewsServiceImpl implements PageViewsService {
    @Autowired
    private PageViewsDao pageViewsDao;
    @Override
    public int pageViewsDelete(int[] pageViewsIds){
        return pageViewsDao.pageViewsDelete(pageViewsIds);
    }

    @Override
    public int pageViewsAdd(PageViews pageViews) {
        return pageViewsDao.pageViewsAdd(pageViews);
    }
}
