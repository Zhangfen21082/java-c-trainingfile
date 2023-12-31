package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") // 先全部拦截
                .excludePathPatterns("/user/login") // 排除的url地址
                .excludePathPatterns("/user/getuser")
                .excludePathPatterns("/user/reg")
                .excludePathPatterns("/login.html")
                .excludePathPatterns("/user/getnum");
    }

//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.addPathPrefix("api", c->true);
//    }
}
