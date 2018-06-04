package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.ProType;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zcy
 * @date 2018-06-04 9:25
 */
public interface ProTypeDao {
    public List<ProType>getAllProType(@Param("start")int start,@Param("end")int end);
    public int getCount();
    public int addProType(ProType proType);
    public int updateProType(ProType proType);
    public int deleteProType(int []proTypeId);
}
