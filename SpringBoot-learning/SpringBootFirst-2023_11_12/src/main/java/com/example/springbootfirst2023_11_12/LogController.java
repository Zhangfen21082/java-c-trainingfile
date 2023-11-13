package com.example.springbootfirst2023_11_12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/log")
public class LogController {

    // 得到日志对象
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @RequestMapping("/getlog")
    public String sayHi() {
        logger.trace("=============trace============");
        logger.debug("=============debug============");
        logger.info("=============info============");
        logger.warn("=============warn============");
        logger.error("=============error============");

        return "Hello";
    }
}
