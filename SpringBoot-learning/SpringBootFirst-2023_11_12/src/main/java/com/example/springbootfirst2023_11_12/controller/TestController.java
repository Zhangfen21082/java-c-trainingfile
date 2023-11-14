package com.example.springbootfirst2023_11_12.controller;

import com.example.springbootfirst2023_11_12.ListTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestController {
    @Autowired
    private ListTest listTest;

    @RequestMapping("/getconfig")
    public void getConf(){
        System.out.println(listTest);
    }

}
