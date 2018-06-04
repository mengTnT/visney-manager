package com.tthome.visneymanager.service;

import com.tthome.visneymanager.entity.Size;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author zcy
 * @date 2018-06-02 15:22
 */
public interface SizeService {
    public Map  getAllSize(int pageIndex,int pageSize);
    public Map addSize(Size size);
    public Map updateSize(Size size);
    public Map deleteSize(int[] sizeIds);
}
