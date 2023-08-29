import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCUPDATE {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/mysql_java?characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("password");
        Connection connection = dataSource.getConnection();

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改学生的学号");
        int Sid = sc.nextInt();
        System.out.println("请输入要修改学生的姓名");
        String Sname = sc.next();
        String sql = "update student set Sname = ? where Sid = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(2, Sid);
        statement.setString(1, Sname);

        int n = statement.executeUpdate();
        System.out.println("n = " + n);
        statement.close();
        connection.close();
    }
}
