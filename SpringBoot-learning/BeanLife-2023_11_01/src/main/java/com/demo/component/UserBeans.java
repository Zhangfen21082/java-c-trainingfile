package com.demo.component;

import com.demo.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserBeans {
    @Bean
    public User user1() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setPassword("123");
        return user;
    }
}
