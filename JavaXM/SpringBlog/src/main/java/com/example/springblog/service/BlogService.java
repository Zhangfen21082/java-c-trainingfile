package com.example.springblog.service;

import com.example.springblog.mapper.BlogMapper;
import com.example.springblog.model.BlogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogMapper blogMapper;

    public List<BlogInfo> queryBlogList(){
        return blogMapper.selectAllBlog();
    }
    public BlogInfo queryBlogDetail(Integer blogId) {
        return blogMapper.selectByIdBlog(blogId);
    }

    public Integer publishBlog(BlogInfo blogInfo) {
        return blogMapper.insertNewBlog(blogInfo);
    }

    public Integer updateBlog(BlogInfo blogInfo) {
        return blogMapper.updateBlog(blogInfo);
    }
}
