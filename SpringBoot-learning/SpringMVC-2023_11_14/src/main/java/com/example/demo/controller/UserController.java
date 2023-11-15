package com.example.demo.controller;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@RestController // @RestController = @ResponseBody + @Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getcookie")
    public String getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

    }
}
