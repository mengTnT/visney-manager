package com.tthome.visneymanager.controller;

import com.tthome.visneymanager.entity.ProImg;
import com.tthome.visneymanager.service.ProImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * @author zcy
 * @date 2018-06-04 10:06
 */
@RestController
@RequestMapping("/proImg")
public class ProImgContrller {
    @Autowired
    private ProImgService proImgService;
    @PostMapping("/getAllProImg")
    public Map getAllProImg(int page ,int rows){
        return proImgService.getAllProImg(page, rows);
    }
    @PostMapping("/addProImg")
    public Map addProImg(ProImg proImg){
        return proImgService.addProImg(proImg);
    }
    @PostMapping("/updateProImg")
    public Map updateProImg(ProImg proImg){
        return proImgService.updateProImg(proImg);
    }
    @PostMapping("/deleteProImg")
    public Map deleteProImg(int [] ids){
        return  proImgService.deleteProImg(ids);
    }
}
