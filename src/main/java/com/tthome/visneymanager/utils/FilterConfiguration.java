package com.tthome.visneymanager.utils;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zcy
 * @date 2018-05-31 11:27
 */
//@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean filterDemo4Registration(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //注入过滤器
        registration.setFilter(new AuthFilter());
        //拦截规则
        registration.addUrlPatterns("*.do");
        //过滤器名称
        registration.setName("AuthFilter");
        //是否自动注册 false 取消Filter的自动注册
        registration.setEnabled(false);
        //过滤器顺序
        registration.setOrder(1);
        return registration;
    }
}
