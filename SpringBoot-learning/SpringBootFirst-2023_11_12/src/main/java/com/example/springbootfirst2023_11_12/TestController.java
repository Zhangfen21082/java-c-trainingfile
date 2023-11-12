package com.example.springbootfirst2023_11_12;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestController {
    @RequestMapping("/hi")
    public String sayHello(String name) {
        return "Hello";
    }
}
