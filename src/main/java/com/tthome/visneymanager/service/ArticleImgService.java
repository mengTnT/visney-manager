package com.tthome.visneymanager.service;

/**
 * @author NBUG
 * @date 2018/5/30 15:52
 */
public interface ArticleImgService {
    /**
     * 删除对应的文章封面
     * @param articleImgIds
     * @return
     */
    public int articleImgDelete(int[] articleImgIds);
}
