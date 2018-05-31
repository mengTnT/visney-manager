package com.tthome.visneymanager.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * @author zcy
 * @date 2018-05-31 8:46
 */
@Configuration
public class MyInterceptorConfig extends WebMvcConfigurerAdapter {



    @Resource
    private MyInterceptor myInterceptor;

    @Override
    public  void addInterceptors(InterceptorRegistry registry) {
       //注册拦截器
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(myInterceptor);
        /*设置拦截器规则*/
        interceptorRegistration.addPathPatterns("/test/*");
        interceptorRegistration.addPathPatterns("/js/*");

        interceptorRegistration.excludePathPatterns("/login");

        interceptorRegistration.excludePathPatterns("/visney-manager");

        super.addInterceptors(registry);
    }
}
