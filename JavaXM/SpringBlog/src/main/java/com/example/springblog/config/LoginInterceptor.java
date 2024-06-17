package com.example.springblog.config;

import com.example.springblog.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.example.springblog.constants.Constant.USER_TOKEN;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从header中获取token
        String userToken = request.getHeader(USER_TOKEN);
        log.info("从header中获取token:{}",userToken);
        // 验证
        boolean isTokenValid = JwtUtils.checkToken(userToken);

        if (!isTokenValid) {
            log.info("token无效，拦截请求");
            response.setStatus(401);
            return false; // 终止请求处理
        }

        log.info("token有效，放行请求");
        return true; // token有效，放行请求

    }
}
