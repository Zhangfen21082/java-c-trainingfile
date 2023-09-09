import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Message> messageList = new ArrayList<>();

    // 让页面获取到数据
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(objectMapper.writeValueAsString(messageList));
    }

    // 浏览器向服务器提交数据
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取到body中的数据并解析
        Message message = objectMapper.readValue(req.getInputStream(), Message.class);
        messageList.add(message);
        resp.setStatus(200);
        System.out.println("成功提交数据："
                + "【" + message.getWho() + "】" + "对【" + message.getWhom() + "】" + "说：" + message.getContent());
    }
}
