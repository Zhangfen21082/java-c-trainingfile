package com.example.demo.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;

@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    // 引入JackSon对String特殊处理
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 如果返回true，那么beforeBodyWrite执行
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 统一返回
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "");
        result.put("data", body);

        // 注意需要对String类型特殊处理，因为String在转换时会报错
        if (body instanceof String) {
            try {
                return objectMapper.writeValueAsString(result);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        // 否则Spring会自动转换
        return result;
    }
}
