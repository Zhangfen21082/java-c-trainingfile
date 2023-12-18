package com.example.demo.config;

import com.example.demo.common.AjaxResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * AjaxResult.java的保底策略
 * 也即：在返回之前检测类型是否为统一对象，如果不是，则封装
 */

@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {
    // 引入JackSon对String特殊处理
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 开关，如果为true则执行beforeBodyWrite
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    /**
     * 对数据格式进行校验和封装
     */
    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 如果本身就是统一的格式，则不需要处理
        if (body instanceof AjaxResult) return body;
        // 如果不是统一的格式，而且是String，则需要特殊处理（因为String不能直接转换）
        if (body instanceof String) {
            return objectMapper.writeValueAsString(AjaxResult.success(body));
        }
        // 如果不是统一的格式，则手动封装
        return AjaxResult.success(body);
    }
}
