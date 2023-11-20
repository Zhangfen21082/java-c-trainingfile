package com.example.mybatisstudy.controller;

import com.example.mybatisstudy.entity.UserInfo;
import com.example.mybatisstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 当返回实体对象时，Spring会自动转换为json
    @RequestMapping("/getuserbyid")
    public UserInfo getUserById(Integer id) {
        if (id == null) return null;
        return userService.getUserById(id);
    }
}
