package com.tthome.visneymanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author NBUG
 * @date 2018/5/28 15:39
 */
@Controller
public class StartController {
    @RequestMapping("/test")
    public String test(){
        return "redirect:/main.html";
    }

}
