-- 建表SQL
create database if not exists java_blog_spring charset utf8mb4;
USE java_blog_spring;

-- 用户表
DROP TABLE IF EXISTS java_blog_spring.user;
CREATE TABLE java_blog_spring.user(
 `id` INT NOT NULL AUTO_INCREMENT,
 `user_name` VARCHAR ( 128 ) NOT NULL,
 `password` VARCHAR ( 128 ) NOT NULL,
 `github_url` VARCHAR ( 128 ) NULL,
 `delete_flag` TINYINT ( 4 ) NULL DEFAULT 0,
 `create_time` DATETIME DEFAULT now(),
 `update_time` DATETIME DEFAULT now(),
 PRIMARY KEY ( id ),
UNIQUE INDEX user_name_UNIQUE ( user_name ASC )) ENGINE = INNODB DEFAULT CHARACTER
SET = utf8mb4 COMMENT = '用户表';

-- 博客表
drop table if exists java_blog_spring.blog;
CREATE TABLE java_blog_spring.blog (
 `id` INT NOT NULL AUTO_INCREMENT,
 `title` VARCHAR(200) NULL,
 `content` TEXT NULL,
 `user_id` INT(11) NULL,
 `delete_flag` TINYINT(4) NULL DEFAULT 0,
 `create_time` DATETIME DEFAULT now(),
 `update_time` DATETIME DEFAULT now(),
 PRIMARY KEY (id))
ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = '博客表';

-- 新增用户信息
insert into java_blog_spring.user (user_name, password,github_url)values
("lay","107","https://www.weibo.com/u/2706896955?c=spr_qdhz_bd_360ss_weibo_mr");
insert into java_blog_spring.user (user_name, password,github_url)
values("muyierf","123456","https://gitee.com/muyierf");
insert into java_blog_spring.blog (title,content,user_id) values("第1篇博
客","lay的筑梦之旅",1);
insert into java_blog_spring.blog (title,content,user_id) values("第1篇博
客","muyierf的第一篇博客",2);