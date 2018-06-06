package com.tthome.visneymanager.service;

import com.tthome.visneymanager.entity.PageViews;

/**
 * @author NBUG
 * @date 2018/5/30 15:42
 */
public interface PageViewsService {
    /**
     * 删除对应的浏览量记录
     * @param pageViewsIds
     * @return
     */
    public int pageViewsDelete(int[] pageViewsIds);

    public int pageViewsAdd(PageViews pageViews);
}
