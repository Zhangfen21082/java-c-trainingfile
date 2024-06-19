package com.example.springblog.model;

import com.example.springblog.utils.DateUtils;
import lombok.Data;

import java.util.Date;

@Data
public class BlogInfo {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;

    public BlogInfo(){

    }

    public BlogInfo(String title, String content, Integer userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public String getCreateTime() {
        return DateUtils.format(createTime);
    }
}
