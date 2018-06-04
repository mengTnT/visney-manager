package com.tthome.visneymanager.service;

import com.tthome.visneymanager.entity.ProCategory;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author zcy
 * @date 2018-06-02 16:35
 */
public interface ProCategoryService {
    public Map  getAllProCategory(int pageIndex,int pageSize);
    public Map addProCategory(ProCategory proCategory);
    public Map updateProCategory(ProCategory proCategory);
    public Map deleteProCategory(int[] proCategoryId);
}
