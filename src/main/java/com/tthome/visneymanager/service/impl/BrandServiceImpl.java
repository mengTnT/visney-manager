package com.tthome.visneymanager.service.impl;

import com.tthome.visneymanager.dao.BrandDao;
import com.tthome.visneymanager.entity.Brand;
import com.tthome.visneymanager.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zcy
 * @date 2018-06-04 14:25
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {
   @Autowired
   private BrandDao brandDao;
    @Override
    public Map getAllBrand(int pageIndex, int pageSize) {
        Map map =new HashMap();
        int start=(pageIndex-1)*pageSize;
        int end=pageSize;
        List<Brand> allBrand = brandDao.getAllBrand(start, end);
        int i = brandDao.getAllCount();
        map.put("total",i);
        map.put("rows",allBrand);
        return map;
    }

    @Override
    public Map addBrand(Brand brand) {
        Map map =new HashMap();
        int i = brandDao.addBrand(brand);
        if(i!=0){
            map.put("msg",true);
        }else {
            map.put("msg",false);
        }
        return map;
    }

    @Override
    public Map updateBrand(Brand brand) {
        Map map =new HashMap();
        int i = brandDao.updateBrand(brand);
        if(i!=0){
            map.put("msg",true);
        }else {
            map.put("msg",false);
        }
        return map;
    }

    @Override
    public Map deleteBrand(int[] brandId) {
        Map map =new HashMap();
        int i = brandDao.deleteBrand(brandId);
        if(i!=0){
            map.put("msg",true);
        }else {
            map.put("msg",false);
        }
        return map;
    }
}
