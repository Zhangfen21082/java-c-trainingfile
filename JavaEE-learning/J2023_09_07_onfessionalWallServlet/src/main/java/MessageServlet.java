import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/*

show databases;
create database confession_wall;
use confession_wall;
create table message (who varchar(50), whom varchar(50), content varchar(1024));

 */

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Message> messageList = new ArrayList<>();

    // 让页面获取到数据
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 声明当前的响应数据格式
        resp.setContentType("application/json; charset=utf-8");
        // 读取数据库内容返回给页面

        try {
            messageList = load();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.getWriter().write(objectMapper.writeValueAsString(messageList));
    }

    // 浏览器向服务器提交数据
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取到body中的数据并解析
        Message message = objectMapper.readValue(req.getInputStream(), Message.class);
        // 向数据库提交内容
        try {
            save(message);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.setStatus(200);
        System.out.println("成功提交数据："
                + "【" + message.getWho() + "】" + "对【" + message.getWhom() + "】" + "说：" + message.getContent());

    }

    // 从数据库查询数据
    private List<Message> load() throws SQLException {
        // 先得有一个数据源
        DataSource dataSource = new MysqlDataSource();
        // 设置url，user和password
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/confession_wall?characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("zxsgdsg6125057");
        // 与服务器建立连接
        Connection connection = dataSource.getConnection();


        // 构造SQL并预处理
        String sql = "select * from message";
        PreparedStatement statement = connection.prepareStatement(sql);


        // 执行SQL得到结果集合
        ResultSet resultSet = statement.executeQuery();

        //遍历结果集合
        // List<Message> messageList = new ArrayList<>();
        while (resultSet.next()) {
            Message message = new Message();
            message.setWho(resultSet.getString("who"));
            message.setWhom(resultSet.getString("whom"));
            message.setContent(resultSet.getString("content"));
            messageList.add(message);

        }

        // 关闭连接释放资源
        statement.close();
        connection.close();

        return messageList;
    }

    // 保存数据到数据库
    private void save(Message message) throws SQLException {
        // 先得有一个数据源
        DataSource dataSource = new MysqlDataSource();
        // 设置url，user和password
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/confession_wall?characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("zxsgdsg6125057");
        // 与服务器建立连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        // 构造SQL并进行预处理
        String sql = "insert into message values(?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        System.out.println(sql);
        statement.setString(1, message.who);
        statement.setString(2, message.whom);
        statement.setString(3, message.content);

        // 执行SQL然后插入
        try {
            int res = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 关闭连接释放资源
        statement.close();
        connection.close();



    }
}
