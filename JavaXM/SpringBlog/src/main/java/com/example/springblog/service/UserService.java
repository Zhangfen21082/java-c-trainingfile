package com.example.springblog.service;


import com.example.springblog.mapper.UserMapper;
import com.example.springblog.model.UserInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserInfo queryUserByName(String userName) {
        return userMapper.selectByName(userName);
    }
}
