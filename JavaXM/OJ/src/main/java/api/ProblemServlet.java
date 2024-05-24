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
import java.sql.SQLException;
import java.util.List;


@WebServlet("/problem")
public class ProblemServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

        String idString = req.getParameter("id");
        ProblemDao problemDao = new ProblemDao();
        if(idString == null || "".equals(idString)) {
            // 查询所有题目
            try {
                List<Problem> problemList = problemDao.selectAll();
                String respString = objectMapper.writeValueAsString(problemList);
                resp.getWriter().write(respString);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            // 查询题目详情
            try {
                Problem problem = problemDao.selectOne(Integer.parseInt(idString));
                String respString = objectMapper.writeValueAsString(problem);
                resp.getWriter().write(respString);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
