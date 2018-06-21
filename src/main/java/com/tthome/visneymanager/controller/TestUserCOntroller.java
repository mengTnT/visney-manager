package com.tthome.visneymanager.controller;

import com.tthome.visneymanager.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcy
 * @date 2018-06-17 15:08
 */

@Controller
@RequestMapping("/test11111")
public class TestUserCOntroller {
    @RequestMapping("/test")
    public String test(ModelMap map){
     User user=new User();
        user.setPassword("123456");
        user.setUserId(1);
        user.setUsername("admin");
        map.put("user",user);
     User  user2=new User();
        user2.setPassword("88888");
        user2.setUserId(2);
        user2.setUsername("zhang");
     List<User> list=new ArrayList<>();
          list.add(user);
          list.add(user2);
        map.put("list",list);
     return "index";
    }
}
