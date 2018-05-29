package com.tthome.visneymanager.controller;

import com.tthome.visneymanager.entity.User;
import com.tthome.visneymanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author zcy
 * @date 2018-05-29 9:28
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String userlogin(String username, String password, HttpSession session,HttpServletRequest request) {
        User user = userService.userLogin(username, password, session,request);
            if (user == null) {
                return "redirect:/index.html";


            } else {
                return "redirect:/main.html";
            }
        }


}
