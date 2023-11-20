package com.example.mybatisexercise.service;

import com.example.mybatisexercise.entity.UserInfo;
import com.example.mybatisexercise.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserInfo getUserById(Integer id) {
        return userMapper.getUserById(id);
    }
}
