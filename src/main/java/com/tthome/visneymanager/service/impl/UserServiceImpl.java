package com.tthome.visneymanager.service.impl;

import com.tthome.visneymanager.dao.UserDao;
import com.tthome.visneymanager.entity.User;
import com.tthome.visneymanager.service.UserService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    Map map=new HashMap();
    @Override
    public Map userLogin(String username, String password, HttpSession session) {
        User user1 = userDao.login(username, password);
        if(user1!=null){
            if(user1.username!=username){
                map.put("msg","用户不存在");
                map.put("login",false);
            }else{
                if(user1.password==password){
                    map.put("msg","登陆成功");
                    map.put("login",true);
                }else{
                    map.put("msg","用户密码错误");
                    map.put("login",false);
                }
            }
        }else{
            map.put("msg","用户不存在");
            map.put("login",false);
        }
        session.setAttribute("user",user1);
        return map;
    }
}
