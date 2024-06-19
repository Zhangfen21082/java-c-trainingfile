package com.example.springblog.controller;


import com.example.springblog.constants.Constant;
import com.example.springblog.model.BlogInfo;
import com.example.springblog.service.BlogService;
import com.example.springblog.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.example.springblog.constants.Constant.USER_TOKEN;

@Slf4j
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

    @RequestMapping("/add")
    public Boolean publishBlog(String title, String content, HttpServletRequest request) {
        // 校验
        if (!StringUtils.hasLength(title) || !StringUtils.hasLength(content)) {
            log.error("title或content为空");
            return false;
        }
        // 获取登录用户
        String userToken = request.getHeader(USER_TOKEN);
        Integer userId = JwtUtils.getUserIdFromToken(userToken);
        if (userId == null || userId <= 0) {
            log.error("未登录");
            return false;
        }

        // 博客发布
        BlogInfo blogInfo = new BlogInfo(title, content, userId);
        Integer result = blogService.publishBlog(blogInfo);
        if (result < 1) {
            log.error("发布失败");
            return false;
        }
        return true;
    }
}
