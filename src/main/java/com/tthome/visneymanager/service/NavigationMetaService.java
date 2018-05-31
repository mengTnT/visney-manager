package com.tthome.visneymanager.service;

import com.tthome.visneymanager.entity.NavigationMeta;

import java.util.Map;

/**
 * @author NBUG
 * @date 2018/5/22 14:29
 */
public interface NavigationMetaService {
    /**
     * 分页查询所有的meta标签内容
     * @return
     */
    public Map metaGetAll(int page,int rows);

    /**
     *新增一个导航meta
     * @param navigationMeta
     * @return
     */
    public int metaAdd(NavigationMeta navigationMeta);

    /**
     * 修改导航meta
     * @param navigationMeta
     * @return
     */
    public int metaUpdate(NavigationMeta navigationMeta);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int metaDelete(int [] ids);

}
