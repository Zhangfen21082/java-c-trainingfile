import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 针对用户表相关操作
public class UserDAO {

    // 根据用户名查询用户 (登录)
    public User selectByUserName(String userName) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            String sql = "Select * from user where userName = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUserName(resultSet.getString("userName"));
                user.setPassWord(resultSet.getString("passWord"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }

        return null;
    }

    // 根据用户ID查询用户 (获取用户信息)
    public User selectByUserId(int userId) throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            String sql = "Select * from user where userId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUserName(resultSet.getString("userName"));
                user.setPassWord(resultSet.getString("passWord"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }

        return null;
    }
}
