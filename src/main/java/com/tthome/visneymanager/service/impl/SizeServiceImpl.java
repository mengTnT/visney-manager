package com.tthome.visneymanager.service.impl;

import com.tthome.visneymanager.dao.SizeDao;
import com.tthome.visneymanager.entity.Size;
import com.tthome.visneymanager.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zcy
 * @date 2018-06-02 15:24
 */
@Service
@Transactional
public class SizeServiceImpl implements SizeService {
    @Autowired
    private SizeDao sizeDao;
    @Override
    public Map getAllSizeBypage(int pageIndex, int pageSize) {
        Map map=new HashMap();
        int start=(pageIndex-1)*pageSize;
        int end=pageSize;
        List<Size> allSize = sizeDao.getAllSizeBypage(start, end);
        int i = sizeDao.getSizeCount();
        map.put("total",i);
        map.put("rows",allSize);
        return map;
    }

    @Override
    public Map getAllSize() {
        Map map=new HashMap();
        map.put("List1",sizeDao.getAllSize());
        return map;
    }

    @Override
    public Map addSize(Size size) {
        Map map=new HashMap();
        int i = sizeDao.addSize(size);
        if(i==0){
            map.put("msg",false);
        }else{
            map.put("msg",true);
        }
        return map;
    }

    @Override
    public Map updateSize(Size size) {
        Map map=new HashMap();
        int i = sizeDao.updateSize(size);
        if(i==0){
            map.put("msg",false);
        }else{
            map.put("msg",true);
        }
        return map;
    }

    @Override
    public Map deleteSize(int[] sizeIds) {
        Map map=new HashMap();
        int i = sizeDao.deleteSize(sizeIds);
        if(i==0){
            map.put("msg",false);
        }else{
            map.put("msg",true);
        }
        return map;
    }
}
