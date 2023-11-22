package com.example.mybatisstudy.mapper;

import com.example.mybatisstudy.entity.UserInfo;
import org.apache.catalina.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void getUserById() {
        UserInfo userInfo = userMapper.getUserById(1);
        System.out.println(userInfo);
    }

    @Test
    void getALL() {
        List<UserInfo> list= userMapper.getALL();
        Assertions.assertEquals(1, list.size());

    }

    @Test
    void addUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("张三");
        userInfo.setPassword("123213");
        userInfo.setCreatetime(LocalDateTime.now());
        userInfo.setUpdatetime(LocalDateTime.now());

        int result = userMapper.addUser(userInfo);
        Assertions.assertEquals(1, result);
    }

    @Test
    void updateUserNameById() {
        int result = userMapper.updateUserNameById(2, "张奇");
        Assertions.assertEquals(1, result);

    }

    @Test
    void getUserByName() {
        List<UserInfo> list = userMapper.getUserByName("李");
        System.out.println(list);
    }
}