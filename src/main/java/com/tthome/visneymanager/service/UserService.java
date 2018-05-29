package com.tthome.visneymanager.service;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author zcy
 * @date 2018-05-29 8:59
 */
public interface UserService {
    Map userLogin(String username, String password, HttpSession session);
}
