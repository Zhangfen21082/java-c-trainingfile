import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 一定要删除下面自动生成的代码
        // super.doGet(req, resp);

        // Tomcat显示
        System.out.println("Hello");
        // 给客户端返回
        resp.getWriter().write("hello");
    }
}
