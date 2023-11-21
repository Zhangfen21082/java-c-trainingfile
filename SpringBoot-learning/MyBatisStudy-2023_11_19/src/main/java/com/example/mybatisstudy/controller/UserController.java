package com.example.mybatisstudy.controller;

import com.example.mybatisstudy.entity.UserInfo;
import com.example.mybatisstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

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

    @RequestMapping("/adduser")
    public String addUser(@RequestBody UserInfo userInfo) {
        userInfo.setCreatetime(LocalDateTime.now());
        userInfo.setUpdatetime(LocalDateTime.now());
        int res = userService.addUser(userInfo);
        if (res == 1) {
            return "插入成功" + userInfo.getId();
        }
        return "插入失败";

    }

    @RequestMapping("/update")
    public String updateUserNameById(Integer id, @RequestParam("newname") String newUserName) {
        int res = userService.updateUserNameById(id, newUserName);
        if (res == 1) {
            return "更改成功";
        }

        return "更改失败";
    }
}
