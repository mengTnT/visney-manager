package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.ProCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zcy
 * @date 2018-06-02 16:17
 */
public interface ProCategoryDao {
    public List<ProCategory> getAllProCategory(@Param("start")int start,@Param("end")int end);
    public int getAllProCategoryCount();
    public int addProCategory(ProCategory proCategory);
    public int updateProCategory(ProCategory proCategory);
    public int deleteProCategory(int[] proCategoryId);
}
