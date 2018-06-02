package com.tthome.visneymanager.service;

import java.util.Map;

import com.tthome.visneymanager.entity.ArticleLabel;

/**
 * @author NBUG
 * @date 2018/5/30 16:08
 */

public interface ArticleLabelService {
    public int articleLabelDelete(int[] articleIds);

    public Map getAllArticleLabel(int pageIndex, int pageSize);
    public Map addArticleLabel(ArticleLabel articleLabel);
    public Map updateArticleLabel(ArticleLabel articleLabel);

}
