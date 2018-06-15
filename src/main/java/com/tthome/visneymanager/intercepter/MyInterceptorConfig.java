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
        //*设置拦截器规则*//*
        //*方法*//*
        interceptorRegistration.addPathPatterns("/articleCategory/*");
        interceptorRegistration.addPathPatterns("/article/*");
        interceptorRegistration.addPathPatterns("/NavigationMeta/*");
        interceptorRegistration.addPathPatterns("/editor/*");
        interceptorRegistration.addPathPatterns("/articleEditor/*");
        interceptorRegistration.addPathPatterns("/articleLabel/*");
        interceptorRegistration.addPathPatterns("/banner/*");
        interceptorRegistration.addPathPatterns("/brand/*");
        interceptorRegistration.addPathPatterns("/modleCode/*");
        interceptorRegistration.addPathPatterns("/proCategory/*");
        interceptorRegistration.addPathPatterns("/product/*");
        interceptorRegistration.addPathPatterns("/proImg/*");
        interceptorRegistration.addPathPatterns("/size/*");


        interceptorRegistration.addPathPatterns("/editor");
        interceptorRegistration.addPathPatterns("/pro");
        //*静态资源*//*
        interceptorRegistration.addPathPatterns("/article.html");
        interceptorRegistration.addPathPatterns("/articleCategory.html");
        interceptorRegistration.addPathPatterns("/articleEditor.html");
        interceptorRegistration.addPathPatterns("/articleLable.html");
        interceptorRegistration.addPathPatterns("/banner.html");
        interceptorRegistration.addPathPatterns("/main.html");
        interceptorRegistration.addPathPatterns("/meta.html");
        interceptorRegistration.addPathPatterns("/modleCode.html");
        interceptorRegistration.addPathPatterns("/proCategory.html");
        interceptorRegistration.addPathPatterns("/product.html");
        interceptorRegistration.addPathPatterns("/proImg.html");
        interceptorRegistration.addPathPatterns("/size.html");

        interceptorRegistration.excludePathPatterns("/login");
        interceptorRegistration.excludePathPatterns("/visney-manager");

        super.addInterceptors(registry);
    }
}
