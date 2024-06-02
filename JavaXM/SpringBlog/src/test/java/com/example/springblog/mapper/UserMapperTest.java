package com.example.springblog.mapper;

import com.example.springblog.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void selectById() {
        UserInfo userInfo = userMapper.selectById(2);
        System.out.println(userInfo);
    }

    @Test
    void selectByName() {
        UserInfo userInfo = userMapper.selectByName("lay");
        System.out.println(userInfo);
    }
}