package com.thaiweb.demo.serv.filter;


import com.thaiweb.demo.serv.domain.UserInfo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description: 人员信息过滤器
 * 需要实现以下三个接口方法
 * @Author oneTi
 * @Date 2018/8/916:36
 */
public class UserSessionFilter implements Filter {

    public void destroy(){}

    public void init(FilterConfig config){}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        UserInfo userSession = (UserInfo) httpServletRequest.getSession().getAttribute("userInfo");
        if(userSession != null)
        {
            System.out.println("UserSessionFilter-->>>doFilter()-->>>userSession");
            //先销毁后添加
            httpServletRequest.getSession().removeAttribute("userInfo");
            httpServletRequest.getSession().setAttribute("userInfo", userSession);
            chain.doFilter(request, response);
        }
//        System.out.println("UserSessionFilter-->>>doFilter()");
//        chain.doFilter(request, response);
    }

}
