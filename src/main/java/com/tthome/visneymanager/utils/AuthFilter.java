package com.tthome.visneymanager.utils;


import com.tthome.visneymanager.entity.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zcy
 * @date 2018-05-29 16:26
 */
public class AuthFilter {
    public static void main(String[] args) {
        System.out.printf("ssss");
    }

@WebFilter(filterName = "AuthFilter",urlPatterns = "/*")
public class AuthFilter  implements Filter {
// 不用过滤的地址
    private static Set<String> GreenUrlSet = new HashSet<String>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


        GreenUrlSet.add("/js/**");
        GreenUrlSet.add("/css/**");
        GreenUrlSet.add("/assets/**");


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       /* HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session=request.getSession();
        User user =(User) session.getAttribute("user");
            if(user!=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.sendRedirect(request.getContextPath()+"/index.html");
                }
*/
    }

    @Override
    public void destroy() {

    }




   /* @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    //标示符：表示当前用户未登录
    String NO_LOGIN = "您还未登录";

    //不需要登录就可以访问的路径(登录)
    String[] includeUrls = new String[]{"/login"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();

        System.out.println("filter url:"+uri);
        //是否需要过滤
        boolean needFilter = isNeedFilter(uri);


        if (!needFilter) { //不需要过滤直接传给下一个过滤器
            filterChain.doFilter(servletRequest, servletResponse);
        } else { //需要过滤器
            // session中包含user对象,则是登录状态
            if(session!=null&&session.getAttribute("user") != null){
                // System.out.println("user:"+session.getAttribute("user"));
                filterChain.doFilter(request, response);
            }else{
                String requestType = request.getHeader("X-Requested-With");
                //判断是否是ajax请求
                if(requestType!=null && "XMLHttpRequest".equals(requestType)){
                    response.getWriter().write(this.NO_LOGIN);
                }else{
                    //重定向到登录页(需要在static文件夹下建立此html文件)
                    response.sendRedirect(request.getContextPath()+"/index.html");
                }
                return;
            }
        }
    }
    public boolean isNeedFilter(String uri) {

        for (String includeUrl : includeUrls) {
            if(includeUrl.equals(uri)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void destroy() {

    }*/
}
