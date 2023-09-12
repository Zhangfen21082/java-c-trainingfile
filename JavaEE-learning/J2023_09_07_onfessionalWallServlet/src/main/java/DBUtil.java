import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

// 用于封装DataSource的单例（懒汉模式，注意线程安全）
public class DBUtil {
    private static volatile DataSource dataSource = null;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if(dataSource == null) {
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/confession_wall?characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
                    ((MysqlDataSource)dataSource).setUser("root");
                    ((MysqlDataSource)dataSource).setPassword("123456");
                }
            }
        }

        return dataSource;
    }

    // 防止直接new DBUtil
    private DBUtil() {};

}
