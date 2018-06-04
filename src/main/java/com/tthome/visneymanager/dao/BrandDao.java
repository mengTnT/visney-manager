package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zcy
 * @date 2018-06-04 14:15
 */
public interface BrandDao {
    public List<Brand> getAllBrand(@Param("start")int start,@Param("end")int end);
    public int getAllCount();
    public int addBrand(Brand brand);
    public  int updateBrand(Brand brand);
    public int deleteBrand(int [] brandId);
}
