package com.example.springblog.service;


import com.example.springblog.mapper.BlogMapper;
import com.example.springblog.mapper.UserMapper;
import com.example.springblog.model.BlogInfo;
import com.example.springblog.model.UserInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private UserMapper userMapper;

    public UserInfo queryUserByName(String userName) {
        return userMapper.selectByName(userName);
    }

    public UserInfo queryUserById(Integer Id) {
        return userMapper.selectById(Id);
    }

    public UserInfo getAuthorInfoByBlogId(Integer blogId) {
        // 获取博客id获取作者id
        BlogInfo blogInfo = blogMapper.selectByIdBlog(blogId);
        if(blogInfo == null || blogInfo.getUserId() < 1) {
            return null;
        }
        return userMapper.selectById(blogInfo.getUserId());

    }
}
