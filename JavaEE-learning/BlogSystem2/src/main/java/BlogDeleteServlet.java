import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/blog_delete")
public class BlogDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判定用户登录状态
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

        // 获取blogId
        String blogId = req.getParameter("blogId");
        if (user == null) {
            // 没有这样的blogId
            resp.setStatus(404);
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().write("blogId有误");
            return;
        }

        // 获取对应Blog
        BlogDAO blogDAO = new BlogDAO();
        Blog blog = null;
        try {
            blog = blogDAO.selectById(Integer.parseInt(blogId));
            if (blog == null) {
                // 没有这样的blog
                resp.setStatus(404);
                resp.setContentType("text/html; charset=utf-8");
                resp.getWriter().write("当前删除的博客不存在");
                return;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // 判断登录用户是否就是文章作者
        if (blog.getUserId() != user.getUserId()) {
            // 不能删除别人的博客
            resp.setStatus(404);
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().write("禁止删除他人博客");
            return;
        }

        // 实际删除
        try {
            blogDAO.delete(Integer.parseInt(blogId));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // 重定向
        resp.sendRedirect("BlogListPage.html");
    }
}
