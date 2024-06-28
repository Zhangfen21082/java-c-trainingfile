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
    public BlogInfo queryBlogDetail(Integer blogId, HttpServletRequest request) {

        BlogInfo blogInfo = blogService.queryBlogDetail(blogId);

        // 顺便判断当前登录用户是否为作者
        String userToken = request.getHeader(USER_TOKEN);
        Integer userId = JwtUtils.getUserIdFromToken(userToken);
        if(userId != null && userId == blogInfo.getUserId()) {
            log.info(String.valueOf(userId));
            log.info(String.valueOf(blogInfo.getUserId()));
            blogInfo.setLoginUser(true);
        } else {
            blogInfo.setLoginUser(false);
        }
        return blogInfo;
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

    @RequestMapping("/update")
    public Boolean update(Integer blogId, String title, String content) {
        // 校验
        log.info(String.valueOf(blogId));
        log.info(String.valueOf(title));
        log.info(String.valueOf(content));
        if (blogId == null || !StringUtils.hasLength(title) || !StringUtils.hasLength(content)) {
            log.error("blogId或title或content为空");
            return false;
        }

        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setId(blogId);
        blogInfo.setTitle(title);
        blogInfo.setContent(content);
        Integer result = blogService.updateBlog(blogInfo);
        if (result < 1) {
            log.error("更新失败");
            return false;
        }

        return true;
    }

    @RequestMapping("/delete")
    public Boolean delete(Integer blogId) {
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setId(blogId);
        blogInfo.setDeleteFlag(1);
        Integer result = blogService.updateBlog(blogInfo);
        if (result < 1) {
            log.error("删除失败");
            return false;
        }

        return true;
    }
}
