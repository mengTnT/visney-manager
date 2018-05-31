package com.tthome.visneymanager.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author NBUG
 * @date 2018/5/28 15:39
 */
@Controller
@RequestMapping("/test")
public class StartController {
@RequestMapping("/test11")
public void test11(){

    System.out.println("sssssssss");
}
}
