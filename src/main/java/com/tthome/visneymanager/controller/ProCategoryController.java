package com.tthome.visneymanager.controller;

import com.tthome.visneymanager.entity.ProCategory;
import com.tthome.visneymanager.service.ProCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
/**
 * @author zcy
 * @date 2018-06-02 16:45
 */
@RestController
@RequestMapping("proCategory")
public class ProCategoryController {
    @Autowired
    private ProCategoryService proCategoryService;
    @PostMapping("/getAllProCategory")
    public Map getAllProCategory(int page,int rows){
        return proCategoryService.getAllProCategory(page, rows);
    }
    @PostMapping("/addProCategory")
    public Map addProCategory(ProCategory proCategory){
        return  proCategoryService.addProCategory(proCategory);
    }
    @PostMapping("/updateProCategory")
    public Map updateProCategory(ProCategory proCategory){
        return  proCategoryService.updateProCategory(proCategory);
    }
    @PostMapping("/deleteProCategorys")
    public Map deleteProCategory(int[] ids){
        return proCategoryService.deleteProCategory(ids);
    }

    /*获取类别*/
    @PostMapping("/getProCategoryBySeries")
    public Map getProCategoryBySeries() {
        return proCategoryService.getProCategoryBySeries();
    }
    @PostMapping("/getProCategoryByStyle")
    public Map getProCategoryByStyle(){
        return  proCategoryService.getProCategoryByStyle();
    }
    @PostMapping("/getProCategoryByTexture")
    public Map getProCategoryByTexture(){
        return proCategoryService.getProCategoryByTexture();
    }
    @PostMapping("/getProCategoryByType")
    public Map getProCategoryByType(){
        return  proCategoryService.getProCategoryByType();
    }
    @PostMapping("/getProCategoryByPosition")
    public Map getProCategoryByPosition(){
        return proCategoryService.getProCategoryByPosition();

    }

}
