import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String blogId = req.getParameter("blogId");
        if (blogId == null) {
            // 这是列表页再请求，直接从session中获取即可
            getUserInfoFromSession(req, resp);

        } else {
            // 这是详情页再请求，查询数据库
        }
    }

    private void getUserInfoFromSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setStatus(403);
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("当前未登录");
            return;
        }

        User user = (User)session.getAttribute("user");
        if (user == null) {
            resp.setStatus(403);
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("当前未登录");
            return;
        }

        // 移除password，避免返回密码
        user.setPassWord("");
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(objectMapper.writeValueAsString(user));


    }
}
