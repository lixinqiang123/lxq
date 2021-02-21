package com.lxq.api.common.Interceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //声明是配置类 配置文件类
public class InterceptorConfig implements WebMvcConfigurer {

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加拦截器类
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new UserInterceptor());

        //配置拦截路径
        interceptorRegistration.addPathPatterns("/**");

        //配置不拦的路径
        interceptorRegistration.excludePathPatterns("/api/user/loginUser");

    }
}
