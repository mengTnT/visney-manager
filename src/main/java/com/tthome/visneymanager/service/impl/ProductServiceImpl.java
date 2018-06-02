package com.tthome.visneymanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.tthome.visneymanager.dao.ProductDao;
import com.tthome.visneymanager.entity.Product;
import com.tthome.visneymanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author NBUG
 * @date 2018/5/10 11:02
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Map selectAll(int page,int rows) {
        Map map = new HashMap();
        int total = productDao.getTotal();
        PageHelper.startPage(page, rows);
        List<Product> products = productDao.selectAll();
        map.put("total", total);
        map.put("rows", products);
        return map;
    }
}


