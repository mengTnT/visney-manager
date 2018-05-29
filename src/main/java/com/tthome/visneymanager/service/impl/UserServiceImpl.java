package com.tthome.visneymanager.service.impl;

import com.tthome.visneymanager.dao.UserDao;
import com.tthome.visneymanager.entity.User;
import com.tthome.visneymanager.service.UserService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zcy
 * @date 2018-05-29 9:06
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User userLogin(String username, String password, HttpSession session, HttpServletRequest request) {

        Map map=new HashMap();
        User user1 = userDao.login(username, password);
        if(user1!=null){
            map.put("login",true);
            session.setAttribute("user",user1);

        }else{
            request.setAttribute("msg","帐户或者用户名输入错误，");
        }

        return user1;
    }
}
