package com.tthome.visneymanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.tthome.visneymanager.dao.NavigationMetaDao;
import com.tthome.visneymanager.entity.NavigationMeta;
import com.tthome.visneymanager.service.NavigationMetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author NBUG
 * @date 2018/5/22 14:33
 */
@Service
public class NavigationMetaServiceImpl implements NavigationMetaService {
    @Autowired
    private NavigationMetaDao navigationMetaDao;

    @Override
    public Map metaGetAll(int page,int rows) {
        Map map=new HashMap();
        int total =navigationMetaDao.getMetaTotal();
        PageHelper.startPage(page,rows);
        List<NavigationMeta> list = navigationMetaDao.metaGetAll();
        map.put("total",total);
        map.put("rows",list);
        return map;
    }

    @Override
    public int metaAdd(NavigationMeta navigationMeta) {
        return 0;
    }
}
