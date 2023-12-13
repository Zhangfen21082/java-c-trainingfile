package com.example.demo.controller;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Transactional
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/add")
    public int add (UserInfo userInfo) {
        // 非空校验
        if (userInfo == null || !StringUtils.hasLength(userInfo.getUsername()) || !StringUtils.hasLength(userInfo.getPassword())) {
            return 0;
        }


        // 业务代码
        userInfo.setCreatetime(LocalDateTime.now().toString());
        userInfo.setUpdatetime(LocalDateTime.now().toString());
        int result = userService.add(userInfo);

        // 故意设置异常并捕获异常
        try {
            int num = 10 / 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // 得到当前事务然后回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }
}
