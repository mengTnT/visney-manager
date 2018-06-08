package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.ArticleImg;

/**
 * @author NBUG
 * @date 2018/5/30 15:54
 */
public interface ArticleImgDao {
    public int articleImgDelete(int[] articleImgIds);
    public int articleImgAdd(ArticleImg articleImg);
    public int articleImgUpdate(ArticleImg articleImg);
}
