import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 利用 queryString 设置状态码
       String type = req.getParameter("type");

       if (type.equals("1")) {
           resp.setStatus(200);
       } else if (type.equals("2")) {
           resp.setStatus(404);
       } else {
           resp.setStatus(504);
       }
    }
}
