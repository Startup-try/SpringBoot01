package com.fdzc.springboot01.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Order(1)
@WebFilter(filterName = "myFilter1",urlPatterns = {"/*"})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器");
   }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入目标资源之前先干点啥");
        chain.doFilter(request,response);
        System.out.println("处理一下服务端返回的response");
    }
    @Override
    public void destroy() {
        System.out.println("过滤器被销毁了");
    }
}


