package com.demo.controller;

import com.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private User user1;

    public void getUser(){
        System.out.println("A | user1:" + user1);
        User u = user1;
        u.setName("李四");
        System.out.println("A | u：" + u);

    }
}
