package com.lxq.api.common.Interceptors;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//配置拦截器
public class UserInterceptor implements HandlerInterceptor {

    //重新prehandler方法

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        System.out.println("拦截器");
        System.out.println(request.getRequestURI());
        return false;
    }
}
