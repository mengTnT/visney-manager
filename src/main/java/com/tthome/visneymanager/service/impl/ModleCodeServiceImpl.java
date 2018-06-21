package com.tthome.visneymanager.service.impl;

import com.tthome.visneymanager.dao.ModleCodeDao;
import com.tthome.visneymanager.entity.ModleCode;
import com.tthome.visneymanager.service.ModleCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zcy
 * @date 2018-06-04 15:30
 */
@Service
@Transactional
public class ModleCodeServiceImpl implements ModleCodeService {

    @Autowired
    private ModleCodeDao modleCodeDao;
    @Override
    public Map getAllModleCodeByPage(int pageIndex, int pageSizes) {
        Map map=new HashMap();
        int start=(pageIndex-1)*pageSizes;
        int end=pageSizes;
        map.put("total",modleCodeDao.getCount());
        map.put("rows",modleCodeDao.getAllModleCodeByPage(start,end));
        return map;
    }

    @Override
    public Map getAllModleCode() {
        Map map=new HashMap();
        List<ModleCode> allModleCodeList = modleCodeDao.getAllModleCode();
        map.put("allModleCodeList",allModleCodeList);
        return map ;
    }

    @Override
    public Map addModleCode(ModleCode modleCode) {
        Map map=new HashMap();
        int i = modleCodeDao.addModleCode(modleCode);
        if(i>0){
            map.put("msg",true);
        }else{
            map.put("msg",false);
        }
        return map;
    }
    @Override
    public Map updateModleCode(ModleCode modleCode) {
        Map map=new HashMap();
        int i = modleCodeDao.updateModleCode(modleCode);
        if(i>0){
            map.put("msg",true);
        }else{
            map.put("msg",false);
        }
        return map;
    }

    @Override
    public Map deleteModleCode(int[] modelCodeIds) {
        Map map=new HashMap();
        int i = modleCodeDao.deleteModleCode(modelCodeIds);
        if(i>0){
            map.put("msg",true);
        }else{
            map.put("msg",false);
        }
        return map;
    }
}
