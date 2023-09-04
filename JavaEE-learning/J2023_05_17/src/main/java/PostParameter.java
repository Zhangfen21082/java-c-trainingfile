import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/postparameter")
public class PostParameter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过发送post请求，获取 body 中的参数
        // 让Servlet知道如何解析
        req.setCharacterEncoding("utf-8");
        String studentId = req.getParameter("studentId");
        String studentName = req.getParameter("studentName");
        System.out.println(studentId);
        System.out.println(studentName);

        // 告诉浏览器类型和编码，让浏览器正常显示
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("studentId: " + studentId + ", " + "studentName: " + studentName);
    }
}
