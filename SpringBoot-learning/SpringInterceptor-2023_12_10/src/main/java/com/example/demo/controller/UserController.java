package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/getuser")
    public String getUser() {
        System.out.println("如果打印了，说明应该拦截但没有拦截");
        return "应该拦截但没有拦截";
    }

    @RequestMapping("/login")
    public String login() {
        System.out.println("没有拦截");
        return "没有拦截";
    }
}
