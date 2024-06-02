package com.example.springblog.mapper;

import com.example.springblog.model.BlogInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlogMapper {
    // 获取所有博客列表
    @Select("select * from blog where delete_flag=0 order by create_time desc")
    List<BlogInfo> selectAllBlog();

    // 根据博客id查询博客
    @Select("select * from blog where delete_flag=0 and id=#{id}")
    BlogInfo selectByIdBlog(Integer blogId);

    // 插入博客
    @Insert("insert into blog (title,content,user_id) values (#{title},#{content},#{userId})")
    Integer insertNewBlog(BlogInfo blogInfo);

    // 修改博客信息（xml）
    Integer updateBlog(BlogInfo blogInfo);

}
