package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.Size;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zcy
 * @date 2018-06-02 15:01
 */
public interface SizeDao {
    public List<Size> getAllSizeBypage(@Param("start")int start,@Param("end")int end);
    public List<Size> getAllSize();
    public int getSizeCount();
    public int addSize(Size size);
    public int updateSize(Size size);
    public  int deleteSize(int[] sizeIds);
}
