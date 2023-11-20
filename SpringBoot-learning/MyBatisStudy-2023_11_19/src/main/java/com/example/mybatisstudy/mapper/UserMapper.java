package com.example.mybatisstudy.mapper;

import com.example.mybatisstudy.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    UserInfo getUserById (Integer id);

    /**
     * 查询全部
     * @return
     */
    List<UserInfo> getALL();

    /**
     * 添加用户
     */

    int addUser(UserInfo userInfo);
}
