package com.example.demo.controller;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;


@RestController // @RestController = @ResponseBody + @Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/showtime")
    public String sayi(@RequestParam("t1") Integer startTime, @RequestParam("t2") Integer endTime) {
        int Time = endTime - startTime;
        return "耗时：" + Time + "s";
    }
}
