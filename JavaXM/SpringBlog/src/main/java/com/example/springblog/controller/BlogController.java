package com.example.springblog.controller;


import com.example.springblog.model.BlogInfo;
import com.example.springblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/blog")
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;
    @RequestMapping("/getlist")
    public List<BlogInfo> queryBlogList(){
        return blogService.queryBlogList();
    }

    @RequestMapping("/getblogdetail")
    public BlogInfo queryBlogDetail(Integer blogId) {
        return blogService.queryBlogDetail(blogId);
    }
}
