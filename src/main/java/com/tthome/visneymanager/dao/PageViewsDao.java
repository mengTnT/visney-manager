package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.PageViews;

/**
 * @author NBUG
 * @date 2018/5/30 15:44
 */
public interface PageViewsDao {
    public int pageViewsDelete(int[] pageViewsIds);
    public int pageViewsAdd(PageViews pageViews);
}
