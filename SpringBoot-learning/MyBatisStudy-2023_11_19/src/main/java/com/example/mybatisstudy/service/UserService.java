package com.example.mybatisstudy.service;

import com.example.mybatisstudy.entity.UserInfo;
import com.example.mybatisstudy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // Spring会找这个interface的实现类
    // 如果有多个实现类就会报错（可以使用resource解决）
    @Autowired
    private UserMapper userMapper;

    // 这个方法名建议和接口中的方法名一致
    public UserInfo getUserById(Integer id) {
        return userMapper.getUserById(id);
    }


}
