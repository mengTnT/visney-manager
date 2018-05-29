package com.tthome.visneymanager.controller;

import com.tthome.visneymanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zcy
 * @date 2018-05-29 9:28
 */
@Controller
@RequestMapping("/userLogin")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public Map userlogin(String username, String password, HttpSession session){

       return  userService.userLogin(username,password,session);
    }
}
