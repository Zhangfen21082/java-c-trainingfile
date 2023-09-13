package login;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/index")
// 登录成功后跳转到的主页
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取Session,这里的Session就是刚才在登录页时登录成功后创建出来的
        HttpSession session = req.getSession(false);
        // 表示登录失败或者就没有登录，没有这样的Session就不让访问
        if(session == null) {
            resp.setStatus(403);
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().write("未登录，拒绝访问主页");
        }

        // 如果有Session,则去取出对应的用户名，并显示欢迎访问
        String username = (String) session.getAttribute("username");
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(username + "! 欢迎来到主页");
    }
}
