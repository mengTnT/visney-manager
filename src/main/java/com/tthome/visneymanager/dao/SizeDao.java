package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.Size;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zcy
 * @date 2018-06-02 15:01
 */
public interface SizeDad {
    public List<Size> getAllSize(@Param("start")int start,@Param("end")int end);
    public int getSizeCount();
    public int addSize();
    public int updateSize();
    public  int deleteSize();
}
