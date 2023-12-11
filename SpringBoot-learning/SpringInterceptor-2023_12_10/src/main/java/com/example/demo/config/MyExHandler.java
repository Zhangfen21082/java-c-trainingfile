package com.example.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@ControllerAdvice
@ResponseBody // 注意

public class MyExHandler {
    /**
     * 拦截所有空指针异常，并统一返回
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public  HashMap<String,Object> nullException(NullPointerException e) {
        HashMap<String,Object> result = new HashMap<>();
        result.put("code", "-1"); // 错误码
        result.put("msg", "空指针异常：" + e.getMessage()); // 错误码描述信息
        result.put("data", null);
        return result;
    }

    @ExceptionHandler(Exception.class)
    public  HashMap<String,Object> exception(Exception e) {
        HashMap<String,Object> result = new HashMap<>();
        result.put("code", "-1"); // 错误码
        result.put("msg", "异常：" + e.getMessage()); // 错误码描述信息
        result.put("data", null);
        return result;
    }
}
