package com.tthome.visneymanager.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 122690792271926213L;
    public Integer userId;
    public String username;
    public String password;
}
