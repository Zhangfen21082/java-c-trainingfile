import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCSELECT {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/mysql_java?characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("password");
        Connection connection = dataSource.getConnection();


        String sql = "select * from student where Sid > 3";
        PreparedStatement statement = connection.prepareStatement(sql);

        //注意查询语句需要使用executeQuery来完成
        ResultSet resultSet = statement.executeQuery();

        //然后需要遍历结果集合
        while(resultSet.next()){
            int Sid = resultSet.getInt("Sid");
            String Sname = resultSet.getString("Sname");
            System.out.println("Sid = " + Sid + ", Sname = " + Sname);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
