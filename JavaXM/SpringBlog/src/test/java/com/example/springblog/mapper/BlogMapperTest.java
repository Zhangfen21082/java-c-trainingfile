package com.example.springblog.mapper;

import com.example.springblog.model.BlogInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BlogMapperTest {

    @Autowired
    private BlogMapper blogMapper;

    @Test
    void selectAllBlog() {
        List<BlogInfo> list = blogMapper.selectAllBlog();
        System.out.println(list);

    }

    @Test
    void selectByIdBlog() {
        BlogInfo blogInfo = blogMapper.selectByIdBlog(1);
        System.out.println(blogInfo);
    }

    @Test
    void insertNewBlog() {
        BlogInfo blogInfo=new BlogInfo();
        blogInfo.setTitle("测试接口");
        blogInfo.setContent("单元测试测试接⼝测试接⼝");
        blogInfo.setUserId(5);
        blogMapper.insertNewBlog(blogInfo);
    }

    @Test
    void updateBlog() {
        BlogInfo blogInfo=new BlogInfo();
        blogInfo.setId(3);
        blogInfo.setTitle("测试接口ing");
        blogInfo.setDeleteFlag(1);
        blogMapper.updateBlog(blogInfo);

    }
}