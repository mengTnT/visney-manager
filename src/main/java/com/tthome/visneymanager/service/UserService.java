package com.tthome.visneymanager.service;

import com.tthome.visneymanager.entity.User;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author zcy
 * @date 2018-05-29 8:59
 */
public interface UserService {
    User userLogin(String username, String password, HttpSession session,HttpServletRequest request);
}
