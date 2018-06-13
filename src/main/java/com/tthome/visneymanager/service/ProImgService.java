package com.tthome.visneymanager.service;

import com.tthome.visneymanager.entity.ProImg;
import java.util.Map;
/**
 * @author zcy
 * @date 2018-06-04 9:54
 */
public interface ProImgService {
    public Map getAllProImg(int pageIndex,int pageSize,int proId);
    public int addProImg(ProImg proImg);
    public int deleteProImg(int[] proImgIds);
    public int updateProImg(ProImg proImg);
    public int  deleteProImgbyProId(int[] proIds);

}
