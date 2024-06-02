package com.example.springblog.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Integer id;
    private String userName;
    private String passWord;
    private String githubUrl;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
