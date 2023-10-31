package com.service;
import org.springframework.stereotype.Controller;

@Controller
public class SController {
    public String SayHello(String name) {
        return name + "：Hello!";
    }
}
