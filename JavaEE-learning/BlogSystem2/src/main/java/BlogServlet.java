import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


// 博客列表页和博客详情页请求处理
@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 按照约定的接口格式返回数据
        resp.setContentType("application/json; charset=utf-8");
        BlogDAO blogDAO = new BlogDAO();

        String blogId = req.getParameter("blogId");
        if (blogId == null) {
            // 这是博客列表页请求
            try {
                List<Blog> blogs = blogDAO.selectAll();
                resp.getWriter().write(objectMapper.writeValueAsString(blogs));
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            // 这是博客详情页请求
            try {
                Blog blog = blogDAO.selectById(Integer.parseInt(blogId));

                resp.getWriter().write(objectMapper.writeValueAsString(blog));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //提交新博客

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取会话和用户信息
    /*
    按照道理来说，这里不需要在判定登录了。因为既然能发起Post请求说明已经登录了
    但是有人可能会利用postman等工具收到发起Post请求
    同时要构造博客对象，必须知道现在谁在登录，才能知道文章作者是谁
     */
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setStatus(403);
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().write("未登录，请登录后再访问");
            return;
        }

        User user = (User)session.getAttribute("user");
        if (user == null) {
            resp.setStatus(403);
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().write("未登录，请登录后再访问");
            return;
        }

        // 获取博客标题和正文
        req.setCharacterEncoding("utf-8");

        // 从请求体中获取JSON数据并解析为Blog对象
        ObjectMapper objectMapper = new ObjectMapper();
        Blog blog = objectMapper.readValue(req.getReader(), Blog.class);

        // 设置博客的用户ID为当前用户的ID
        blog.setUserId(user.getUserId());

        // 构造Blog对象并插入到数据库中
        BlogDAO blogDAO = new BlogDAO();
        try {
            blogDAO.insert(blog);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // 发布成功后重定向到列表页
        resp.sendRedirect("BlogListPage.html");
    }
}

