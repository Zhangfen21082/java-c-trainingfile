package com.example.mybatisexercise.mapper;

import com.example.mybatisexercise.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserInfo getUserById(Integer id);
}
