import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
一个Java对象，要想正确解析，必须满足以下条件
    这个类的属性务必是public或者带有public的getter/setter，否则jackson无法访问到这个对象的属性
    这个类务必要有无参版本的构造方法（如果不写编译器自动生成无参构造）
 */
class Student {
    public int studentId;
    public String studentName;
}

@WebServlet("/json")
public class JacksonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 假设请求的body格式如下
        // {studentId: 10, studentName: "张三"}

        // 创建Jackson核心类
        ObjectMapper objectMapper = new ObjectMapper();
        // 解析json
        Student s = objectMapper.readValue(req.getInputStream(), Student.class);
        System.out.println(s.studentId);
        System.out.println(s.studentName);

        // 修改
        s.studentId=20;
        s.studentName="李四";
        // 返回json
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(objectMapper.writeValueAsString(s));
    }
}
