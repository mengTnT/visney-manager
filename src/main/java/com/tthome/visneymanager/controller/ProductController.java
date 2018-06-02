package com.tthome.visneymanager.controller;

import com.tthome.visneymanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author NBUG
 * @date 2018/5/10 11:05
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/getAll")
    public Map getAll(int page,int rows) {
        return productService.selectAll(page, rows);
    }

}
