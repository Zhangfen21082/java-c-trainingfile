package upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/upload")
// 专门针对上传文件的注解
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 这里参数中的 name 和input标签中的name一致
        Part part = req.getPart("myfile");
        // 获取文件名
        System.out.println(part.getSubmittedFileName());
        // 获取文件大小
        System.out.println(part.getSize());
        // 获取文件类型
        System.out.println(part.getContentType());
        // 保存文件
        part.write("D:/programData/temp/test.jpg");
    }
}
