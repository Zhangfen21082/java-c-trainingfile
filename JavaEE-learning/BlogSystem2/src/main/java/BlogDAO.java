import java.beans.PropertyEditorSupport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 针对博客表的一些操作
public class BlogDAO  {
    // 插入博客到数据库中 (发布博客)
    public void insert(Blog blog) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 获取数据源并连接
            connection = DBUtil.getConnection();
            // 构造SQL
            String sql = "insert into blog values(null, ?, ?, now(), ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getContent());
            statement.setInt(3, blog.getUserId());
            // 执行SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("插入失败！");
            } else {
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            DBUtil.close(connection, statement, null);
        }

    }

    // 根据博客id查询指定博客 (博客详情页)
    public Blog selectById(int blogId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            String sql = "select * from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, blogId);
            resultSet = statement.executeQuery();

            // 遍历结果，如果有查询结果则返回
            if (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("content"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blog.setUserId(resultSet.getInt("userId"));


                return blog;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    // 查询博客列表 (博客列表页)
    public List<Blog> selectAll() throws SQLException {
        List<Blog> blogs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            // 注意发布时间要降序排序
            String sql = "select * from blog order by postTime desc";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            // 遍历结果，如果有查询结果则返回
            while (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                // 注意：为了避免因博客content太多而导致博客列表页博客摘要显示过长
                // 规定当content长度大于100时只显示部分内容，用户如果想要查看完整内容则需要点击按钮
                String content = resultSet.getString("content");
                if (content.length() > 100) {
                    content = content.substring(0, 100) + "......";
                }
                blog.setContent(content);
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blog.setUserId(resultSet.getInt("userId"));
                blogs.add(blog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return blogs;
    }

    // 根据博客id删除博客 (删除博客)
    public void delete (int blogId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBUtil.getConnection();
            String sql = "delete from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, blogId);
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("删除失败！");
            } else {
                System.out.println("删除成功！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }
}
