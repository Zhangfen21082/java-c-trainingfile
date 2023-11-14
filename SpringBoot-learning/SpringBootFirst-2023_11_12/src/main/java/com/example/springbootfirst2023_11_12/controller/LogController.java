package com.example.springbootfirst2023_11_12.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j
@RequestMapping("/log")
public class LogController {
    // 得到日志对象
    @RequestMapping("/getlog")
    public String sayHi() {
        log.trace("=============slf4j:trace============");
        log.debug("=============slf4j:debug============");
        log.info("=============slf4j:info============");
        log.warn("=============slf4j:warn============");
        log.error("=============slf4j:error============");
        return "Hello";
    }
}
