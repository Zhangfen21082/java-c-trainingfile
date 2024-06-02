package com.example.springblog.config;

import com.example.springblog.model.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler
    public Result handler (Exception e) {
        return Result.fail(e.getMessage());
    }
}
