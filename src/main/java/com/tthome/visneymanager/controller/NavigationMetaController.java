package com.tthome.visneymanager.controller;

import com.tthome.visneymanager.entity.NavigationMeta;
import com.tthome.visneymanager.service.NavigationMetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author NBUG
 * @date 2018/5/22 14:48
 */
@RestController
@RequestMapping("/NavigationMeta")
public class NavigationMetaController {
    @Autowired
    private NavigationMetaService navigationMetaService;

    @RequestMapping("/metaGetAll")
    public Map metaGetAll(int page, int rows) {

        return navigationMetaService.metaGetAll(page, rows);
    }

    @PostMapping("/metaAdd")
    public int metaAdd(NavigationMeta navigationMeta) {
        return navigationMetaService.metaAdd(navigationMeta);

    }
}
