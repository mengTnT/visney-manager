package com.tthome.visneymanager.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author NBUG
 * @date 2018/5/11 16:30
 */
@Data
public class ArticleEditor implements Serializable {

    private static final long serialVersionUID = 6438820651707809486L;
    private Integer articleEditorId;
    private String articleEditorName;
}
