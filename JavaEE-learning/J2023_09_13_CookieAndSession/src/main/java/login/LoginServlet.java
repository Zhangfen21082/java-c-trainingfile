package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // form表单数据将会提交到服务器
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从请求中获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 验证
        if ("zhangsan".equals(username) && "123321".equals(password)) {
            // 成功
            // 创建Session
            HttpSession session = req.getSession(true);
            // 使用session存储信息
            session.setAttribute("username", "zhangsan");
            // 让响应重定向到主页
            resp.sendRedirect("index");
        } else {
            // 失败
            resp.setStatus(403);
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().write("登录失败，用户名或密码错误");

        }


    }
}
