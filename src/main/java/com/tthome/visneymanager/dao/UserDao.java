package com.tthome.visneymanager.dao;

import com.tthome.visneymanager.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author zcy
 * @date 2018-05-29 8:54
 */
public interface UserDao {
    public User login(@Param("username")String username,@Param("password")String password);
}
