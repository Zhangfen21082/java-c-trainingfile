package com.example.mybatisstudy.mapper;

import com.example.mybatisstudy.entity.view.ArticleInfoView;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleMapperTest {
    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void getById() {
        ArticleInfoView articleInfoView = articleMapper.getById(1);
        System.out.println(articleInfoView);
    }
}