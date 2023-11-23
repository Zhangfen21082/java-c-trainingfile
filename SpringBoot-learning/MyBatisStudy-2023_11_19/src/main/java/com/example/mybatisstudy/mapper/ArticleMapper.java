package com.example.mybatisstudy.mapper;

import com.example.mybatisstudy.entity.ArticleInfo;
import com.example.mybatisstudy.entity.view.ArticleInfoView;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    ArticleInfoView getById (Integer id);
}
