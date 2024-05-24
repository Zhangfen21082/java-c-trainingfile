package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.Problem;
import dao.ProblemDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

@WebServlet("/compile")
public class CompileServlet extends HttpServlet{
    static class CompileRequest{
        public int id;
        public String code;
    }

    static class CompileResponse {
        public int error;
        public String reason;
        public String stdout;
    }

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
            1：先读取请求的正文，按照json格式进行解析
            2：根据id从数据库中查找题目详情，得到测试用例代码
            3：将用户提交代码和测试用例代码，拼接为完整代码
            4：创建一个Task实例，调用compileAndArun执行
            5：根据Task运行结果，包装为一个HTTP响应
         */

        // 1
        String body = readBody(req);
        CompileRequest compileRequest = objectMapper.readValue(body, CompileRequest.class);
        // 2
        ProblemDao problemDao = new ProblemDao();
        // 测试用例代码
        StringBuilder testCode = new StringBuilder();
        // 用户提交代码
        StringBuilder requestCode = new StringBuilder();
        try {
            Problem problem = problemDao.selectOne(compileRequest.id);

            testCode.append(problem.getTestCode());
            requestCode.append(compileRequest.code);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 3
        String finalCode = mergeCode(testCode.toString(), requestCode.toString());
        System.out.println(finalCode);


    }

    private static String mergeCode(String testCode, String requestCode) {
        /*
        合并方法比较简单，就是把测试用例代码的main方法嵌入到用户提交代码中
        具体来说，寻找用户提交代码中最后一个"}"的位置，然后截取字符串
         */

        int pos = requestCode.lastIndexOf("}");
        if (pos == -1) {
            return null;
        }

        String substr = requestCode.substring(0, pos);

        return substr + testCode + "\n}";


    }


    private static String readBody(HttpServletRequest req) throws UnsupportedEncodingException {
        /*
            1：获取body长度（ContentLength()）
            2：准备好对应长度的byte[]
            3：通过req.getInputStream方法获取Body流对象
            4：基于这个流对象，读取内容，然后将内容放到byte[]数组中
            5：将byte[]构造为String
         */
        int contentLength = req.getContentLength();
        byte[] buffer = new byte[contentLength];
        try(InputStream inputStream = req.getInputStream()) {
            inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(buffer, "utf8");

    }
}
