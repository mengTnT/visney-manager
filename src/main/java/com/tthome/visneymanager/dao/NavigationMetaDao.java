package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.NavigationMeta;

import java.util.List;
import java.util.Map;

/**
 * @author NBUG
 * @date 2018/5/22 14:34
 */
public interface NavigationMetaDao {
    public List<NavigationMeta> metaGetAll();
    public int getMetaTotal();
    public int metaAdd(NavigationMeta navigationMeta);
    public int metaUpdate(NavigationMeta navigationMeta);
    public int metaDelete(int [] ids);

}
