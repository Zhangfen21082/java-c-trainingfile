package com.example.demo;
import org.springframework.web.bind.annotation.*;


@RestController // @RestController = @ResponseBody + @Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/hi")
    public String sayi() {
        return "<h1>Hello, Spring MVC</h1>";
    }
}
