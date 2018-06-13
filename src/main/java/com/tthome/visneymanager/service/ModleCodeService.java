package com.tthome.visneymanager.service;

import com.tthome.visneymanager.entity.ModleCode;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author zcy
 * @date 2018-06-04 15:22
 */
public interface ModleCodeService {
    public Map getAllModleCode(int  pageIndex, int pageSizes);
    public Map  addModleCode(ModleCode modleCode);
    public Map updateModleCode(ModleCode modleCode);
    public Map deleteModleCode(int[] modelCodeIds);
}
