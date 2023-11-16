package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController // @RestController = @ResponseBody + @Controller
@RequestMapping("/user")

public class UserController {
    @RequestMapping("/json")
    public HashMap<String, String> test() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");

        return map;
    }

}