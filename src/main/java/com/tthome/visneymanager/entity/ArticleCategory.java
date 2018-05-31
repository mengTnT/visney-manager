package com.tthome.visneymanager.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author NBUG
 * @date 2018/5/11 16:42
 */
@Data
public class ArticleCategory implements Serializable {

    private static final long serialVersionUID = 5072225058629885094L;
    private int articleCategoryId;
    private String articleCategoryName;
}
