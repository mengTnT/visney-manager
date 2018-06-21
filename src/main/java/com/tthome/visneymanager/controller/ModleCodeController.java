package com.tthome.visneymanager.controller;

import com.tthome.visneymanager.entity.ModleCode;
import com.tthome.visneymanager.service.ModleCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
/**
 * @author zcy
 * @date 2018-06-04 15:37
 */
@RestController
@RequestMapping("/modleCode")
public class ModleCodeController {
    @Autowired
    private ModleCodeService modleCodeService;
    @PostMapping("/getAllModleCode")
    public Map getAllModleCode()
    {return modleCodeService.getAllModleCode();}
    @PostMapping("/getAllModleCodeByPage")
    public Map getAllModleCodeByPage(int page,int rows)
    {return modleCodeService.getAllModleCodeByPage(page, rows);}
    @PostMapping("/addModleCode")
    public Map addModleCode(ModleCode modleCode){return modleCodeService.addModleCode(modleCode);}
    @PostMapping("/updateModleCode")
    public Map updateModleCode(ModleCode modleCode){return modleCodeService.updateModleCode(modleCode);}
    @PostMapping("/deleteModleCode")
    public Map deleteModleCode(int[] ids){return  modleCodeService.deleteModleCode(ids);}

}
