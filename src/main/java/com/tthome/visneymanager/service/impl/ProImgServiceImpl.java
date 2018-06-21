package com.tthome.visneymanager.service.impl;

import com.tthome.visneymanager.dao.ProImgDao;
import com.tthome.visneymanager.entity.ProImg;
import com.tthome.visneymanager.service.ProImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zcy
 * @date 2018-06-04 9:57
 */
@Service
@Transactional
public class ProImgServiceImpl implements ProImgService {
    @Autowired
    private ProImgDao proImgDao;
    @Override
    public Map getAllProImg(int pageIndex, int pageSize,int proId) {
        int start=(pageIndex-1)*pageSize;
        int end=pageSize;
        Map map=new HashMap();
        List<ProImg> allProImg = proImgDao.getAllProImg(start, end,proId);
        int i = proImgDao.getAllCount(proId);
        map.put("total",i);
        map.put("rows",allProImg);
        return map;
    }

    @Override
    public int addProImg(ProImg proImg) {
        Map map=new HashMap();
        int i = proImgDao.addProImg(proImg);
        return i;
    }

    @Override
    public int deleteProImg(int[] proImgIds) {
        Map map=new HashMap();
        int i = proImgDao.deleteProImg(proImgIds);
        return i;
    }

    @Override
    public int updateProImg(ProImg proImg) {
        Map map=new HashMap();
        int i = proImgDao.updateProImg(proImg);
        return i;
    }

    @Override
    public int deleteProImgbyProId(int[] proIds) {
        return proImgDao.deleteProImgbyProId(proIds);
    }
}
