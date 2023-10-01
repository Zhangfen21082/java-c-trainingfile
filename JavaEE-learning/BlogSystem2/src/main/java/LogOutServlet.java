import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// 注销逻辑
@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取当前会话
        HttpSession session = req.getSession(false);
        if (session == null) {
            // 没有会话，当前是未登录状态
            resp.setStatus(403);
            return;
        }

        // 由于在判定是否登录的逻辑中要求会话和user必须同时存在，所以在这里我们可以直接删除user即可
        session.removeAttribute("user");
        // 重定向到登录页面
        resp.sendRedirect("BlogLoginPage.html");
    }
}
