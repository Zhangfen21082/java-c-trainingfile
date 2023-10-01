-- 创建数据库
create database if not exists BlogSystem2;

-- 使用数据库
use BlogSystem2;


drop table if exists blog;

-- 创建博客表blog
create table blog (
    blogId int primary key auto_increment,
    title varchar(256),
    content text,
    postTime datetime,
    userId int
);

-- 创建用户表user
drop table if exists user;
create table user (
    userId int primary key  auto_increment,
    userName varchar(50) unique,
    passWord varchar(50)
);

-- 插入数据测试
insert into blog values(null, "第一篇博客", "今天我们介绍博客系统的实现", now(), 1);
insert into blog values(null, "第二篇博客", "今天我们再次介绍博客系统的实现", now(), 2);
insert into blog values(null, "第三篇博客", "今天我们第三次次介绍博客系统的实现", now(), 1);
insert into blog values(null, "第四篇博客", "### 第一：任务内容 - asd1", now(), 2);

insert into user values(1, "张三", "123");
insert into user values(2, "李四", "123");