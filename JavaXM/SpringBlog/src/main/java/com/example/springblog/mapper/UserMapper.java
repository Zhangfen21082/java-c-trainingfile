package com.example.springblog.mapper;

import com.example.springblog.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    // 根据id查询用户信息
    @Select("select * from user where id = #{id} and delete_flag=0")
    UserInfo selectById(Integer id);

    // 根据用户名查询用户信息
    @Select("select * from user where user_name = #{userName} and delete_flag=0")
    UserInfo selectByName(String name);
}
