package com.tthome.visneymanager.utils;


import com.tthome.visneymanager.entity.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zcy
 * @date 2018-05-29 16:26
 */



//@WebFilter(filterName = "AuthFilter",urlPatterns = "/*")
public class AuthFilter extends HttpServlet implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("====>Filter启动 ");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 将请求转换成HttpServletRequest 请求
     /*   HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String path = req.getContextPath();
        String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path;
        HttpSession session = req.getSession(true);
        Object user = (User) session.getAttribute("user");
        if (user == null ) {
            resp.setHeader("Cache-Control", "no-store");
            resp.setDateHeader("Expires", 0);
            resp.setHeader("Prama", "no-cache");
            //此处设置了访问静态资源类
            resp.sendRedirect(basePath+"/index.html");
        } else {
            // Filter 只是链式处理，请求依然转发到目的地址。
            filterChain.doFilter(req, resp);
        }*/
    }
    @Override
    public void destroy() {

    }
}
    