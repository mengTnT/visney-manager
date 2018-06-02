package com.tthome.visneymanager.service.impl;

import com.tthome.visneymanager.dao.ProCategoryDao;
import com.tthome.visneymanager.entity.ProCategory;
import com.tthome.visneymanager.service.ProCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zcy
 * @date 2018-06-02 16:37
 */
@Service
@Transactional
public class ProCategoryServiceImpl implements ProCategoryService {
    @Autowired
    private ProCategoryDao proCategoryDao;

    @Override
    public Map getAllProCategory(int pageIndex, int pageSize) {
        int start=(pageIndex-1)*pageSize;
        int end=pageSize;
        Map map=new HashMap();
        List allProCategory = proCategoryDao.getAllProCategory(start, end);
        int i = proCategoryDao.getAllProCategoryCount();
        map.put("total",i);
        map.put("rows",allProCategory);
        return map;
    }

    @Override
    public Map addProCategory(ProCategory proCategory) {
        Map map=new HashMap();
        int i = proCategoryDao.addProCategory(proCategory);
        if (i==0){
            map.put("msg",false);
        }else{
            map.put("msg",true);
        }
        return map;
    }

    @Override
    public Map updateProCategory(ProCategory proCategory) {
        Map map=new HashMap();
        int i = proCategoryDao.updateProCategory(proCategory);
        if (i==0){
            map.put("msg",false);
        }else{
            map.put("msg",true);
        }
        return map;
    }

    @Override
    public Map deleteProCategory(int[] proCategoryId) {
        Map map=new HashMap();
        int i = proCategoryDao.deleteProCategory(proCategoryId);
        if (i==0){
            map.put("msg",false);
        }else{
            map.put("msg",true);
        }
        return map;
    }
}
