package com.example.mybatisstudy.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserInfo {
    private int id;
    private String username;
    private String password;
    private String photo;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private int state;
}
