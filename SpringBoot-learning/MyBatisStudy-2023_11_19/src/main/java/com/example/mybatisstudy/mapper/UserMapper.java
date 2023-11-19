package com.example.mybatisstudy.mapper;

import com.example.mybatisstudy.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserInfo getUserById (Integer id);
}
