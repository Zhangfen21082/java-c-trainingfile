import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取用户名和密码
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username == null || "".equals(username) || password == null || "".equals(password)) {
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().write("登录失败！用户名或密码为空");
            resp.setStatus(403);
            return;
        }

        // 查询数据库，验证用户名和密码是否正确
        UserDAO userDAO = new UserDAO();
        User user = null;
        try {
            user = userDAO.selectByUserName(username);
            if (user == null || !user.getPassWord().equals(password)) {
                resp.setContentType("text/html; charset=utf-8");
                resp.getWriter().write("登录失败！用户名或密码错误");
                resp.setStatus(401);

                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 如果正确则创建一个会话对象
        // 保证在访问其他页面时可以直接判定是哪个用户在访问
        HttpSession session = req.getSession(true);
        session.setAttribute("user", user);

        // 然后下面让客户端重定向即可
        /*需要注意，重定向操作对ajax请求无效，因此需要给页面返回一个
        json响应，包含重定向URL信息，时客户端进行重定向
         */
//        resp.setContentType("application/json");
//        String redirectUrl = req.getContextPath() + "/BlogListPage.html";
//        Map<String, String> responseMap = new HashMap<>();
//        responseMap.put("redirectUrl", redirectUrl);
//        ObjectMapper objectMapper = new ObjectMapper();
//        resp.getWriter().write(objectMapper.writeValueAsString(responseMap));

        // resp.sendRedirect("BlogListPage.html");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判定登录状态
        // 获取会话
        HttpSession session = req.getSession(false);
        // 没有会话则为未登录
        if (session == null) {
            resp.setStatus(403);
            return;
        }

        // 如果有会话则已经登录，获取用户
        User user = (User)session.getAttribute("user");
        // 这里是为了结合注销逻辑，注销时会直接删除user
        if (user == null) {
            resp.setStatus(403);
            return;
        }

        // 返回200
        resp.setStatus(200);

    }
}
