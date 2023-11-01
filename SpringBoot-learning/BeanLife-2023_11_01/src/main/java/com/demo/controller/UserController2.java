package com.demo.controller;

import com.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController2 {

    @Autowired
    private User user1;

    public void getUser() {
        System.out.println("B | user1:" + user1);
    }

}
