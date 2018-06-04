package com.tthome.visneymanager.service;

import com.tthome.visneymanager.entity.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author zcy
 * @date 2018-06-04 14:23
 */
public interface BrandService {
    public Map getAllBrand(int pageIndex,int pageSizes);
    public Map addBrand(Brand brand);
    public  Map updateBrand(Brand brand);
    public Map deleteBrand(int [] brandId);
}

