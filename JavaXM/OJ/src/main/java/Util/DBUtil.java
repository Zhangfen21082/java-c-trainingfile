package Util;


import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/oj_database?characterEncoding=utf8&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "zxsgdsg6125057";

    private static volatile DataSource dataSource = null;
    private static DataSource getDataSource() {
        if(dataSource == null){
            synchronized (DBUtil.class) {
                if(dataSource == null) {
                    MysqlDataSource mysqlDataSource = new MysqlDataSource();
                    mysqlDataSource.setUrl(URL);
                    mysqlDataSource.setUrl(USERNAME);
                    mysqlDataSource.setPassword(PASSWORD);
                    dataSource = mysqlDataSource;
                }
            }
        }

        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
