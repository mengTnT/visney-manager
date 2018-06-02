package com.tthome.visneymanager.service;

import java.util.Map;

/**
 * @author NBUG
 * @date 2018/5/10 11:01
 */
public interface ProductService {
    /**
     * 查询全部商品
     *
     * @return
     */
    public Map selectAll(int page,int rows);


}
