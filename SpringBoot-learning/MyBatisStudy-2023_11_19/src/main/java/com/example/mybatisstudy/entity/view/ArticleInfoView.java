package com.example.mybatisstudy.entity.view;

import com.example.mybatisstudy.entity.ArticleInfo;
import lombok.Data;

import java.io.Serializable;


@Data
public class ArticleInfoView extends ArticleInfo implements Serializable {
    private String username;

    @Override
    public String toString() {
        return "ArticleInfoView{" +
                "username='" + username + '\'' +
                "} " + super.toString();
    }
}
