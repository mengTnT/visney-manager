package com.tthome.visneymanager.service;

import com.tthome.visneymanager.entity.ArticleImg;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * 添加封面图片
     * @param articleImg
     * @return
     */
    public int articleImgAdd(ArticleImg articleImg);
}
