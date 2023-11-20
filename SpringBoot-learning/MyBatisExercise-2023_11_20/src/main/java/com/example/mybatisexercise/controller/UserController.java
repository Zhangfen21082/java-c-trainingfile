package com.example.mybatisexercise.controller;

import com.example.mybatisexercise.entity.UserInfo;
import com.example.mybatisexercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("getuserbyid")
    public UserInfo getUserById(Integer id) {
        return userService.getUserById(id);
    }
}
