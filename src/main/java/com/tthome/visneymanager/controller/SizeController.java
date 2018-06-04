package com.tthome.visneymanager.controller;

import com.tthome.visneymanager.entity.Size;
import com.tthome.visneymanager.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
/**
 * @author zcy
 * @date 2018-06-02 15:31
 */
@RestController
@RequestMapping("/size")
public class SizeController {
    @Autowired
    private SizeService sizeService;

    @PostMapping("/getAllSize")
     public Map getAllSize(int page,int rows){
         return sizeService.getAllSize(page,rows);
     }
    @PostMapping("/addSize")
     public Map addSize(Size size){
        return sizeService.addSize(size);
     }
     @PostMapping("updateSize")
     public Map updateSize(Size size){
        return sizeService.updateSize(size);
     }
     @PostMapping("deleteSize")
    public Map deleteSize(int [] ids){
        return sizeService.deleteSize(ids);
     }
}
