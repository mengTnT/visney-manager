package com.tthome.visneymanager.controller;

import com.tthome.visneymanager.entity.Brand;
import com.tthome.visneymanager.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zcy
 * @date 2018-06-04 14:34
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;
    @PostMapping("/getAllBrand")
    public Map getAllBrand(int page,int rows){return brandService.getAllBrand(page, rows); }
    @PostMapping("/addBrand")
    public  Map addBrand(Brand brand){return brandService.addBrand(brand);}
    @PostMapping("/updateBrand")
    public Map updateBrand(Brand brand){return  brandService.updateBrand(brand); }
    @PostMapping("/deleteBrand")
    public Map deleteBrand(int[] ids){return brandService.deleteBrand(ids);}
}
