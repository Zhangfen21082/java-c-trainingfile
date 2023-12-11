package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/getnum")
    public Integer getNum() {
        return new Random().nextInt(10);
    }

    @RequestMapping("/getuser")
    public String getUser() {

        return "getuser";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
