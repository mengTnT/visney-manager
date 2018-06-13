package com.tthome.visneymanager.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageViews implements Serializable {
    private static final long serialVersionUID = 3350598890141945168L;
    private Integer pageViewsId;
    private int pageViewsCount=0;
}