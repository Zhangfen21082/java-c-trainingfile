package com.example.springblog.controller;

import com.example.springblog.model.Result;
import com.example.springblog.model.UserInfo;
import com.example.springblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public Result login(String userName, String password) {
        // 参数校验
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return Result.fail("用户名或密码不能为空");
        }
        // 查询用户是否存在
        UserInfo userInfo = userService.queryUserByName(userName);
        if(userInfo == null || userInfo.getId() < 0) {
            return Result.fail("用户不存在");
        }

        // 密码校验
        if(!password.equals(userInfo.getPassWord())) {
            return Result.fail("密码错误");
        }
        return null;
    }
}
