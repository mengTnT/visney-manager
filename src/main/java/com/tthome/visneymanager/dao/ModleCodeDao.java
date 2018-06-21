package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.ModleCode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zcy
 * @date 2018-06-04 15:15
 */
public interface ModleCodeDao {

    public List<ModleCode> getAllModleCodeByPage(@Param("start")int start,@Param("end")int end);
    public List<ModleCode> getAllModleCode();
    public int getCount();
    public int  addModleCode(ModleCode modleCode);
    public int updateModleCode(ModleCode modleCode);
    public int deleteModleCode(int[] modelCodeIds);
}
