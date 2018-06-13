package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.ProImg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zcy
 * @date 2018-06-04 9:34
 */
public interface ProImgDao {
    public List<ProImg> getAllProImg(@Param("start")int start,@Param("end")int end,@Param("proId")int proId);
    public int getAllCount();
    public int addProImg(ProImg proImg);
    public int updateProImg(ProImg proImg);
    public int deleteProImg(int [] proImgIds);
    public int deleteProImgbyProId(int[] proIds);

}
