package com.tthome.visneymanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.tthome.visneymanager.dao")
@ServletComponentScan(value ={"com.tthome.visneymanager.utils.AuthFilter"})
public class VisneyManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(VisneyManagerApplication.class, args);
    }
}
