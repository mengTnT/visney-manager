package com.tthome.visneymanager.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author NBUG
 * @date 2018/5/23 11:28
 */
@Data
public class ArticleImg implements Serializable {

    private static final long serialVersionUID = 4720007967091848857L;
    private Integer articleImgId;
    private String articleImgAlt;
    private String articleImgSrc;
}
