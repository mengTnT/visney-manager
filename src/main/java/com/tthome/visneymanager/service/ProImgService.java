package com.tthome.visneymanager.service;

import com.tthome.visneymanager.entity.ProImg;
import java.util.Map;
/**
 * @author zcy
 * @date 2018-06-04 9:54
 */
public interface ProImgService {
    public Map getAllProImg(int pageIndex,int pageSize);
    public Map addProImg(ProImg proImg);
    public Map deleteProImg(int[] proImgIds);
    public Map updateProImg(ProImg proImg);

}
