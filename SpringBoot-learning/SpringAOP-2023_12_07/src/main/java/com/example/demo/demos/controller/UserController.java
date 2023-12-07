package com.example.demo.demos.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/hi")
    public String sayHi() {
        System.out.println("执行了sayHi()方法");
        return "Hi, ";
    }

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("执行了sayHello()方法");
        return "Hello, ";
    }
}
