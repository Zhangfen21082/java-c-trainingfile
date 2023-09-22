import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
}

