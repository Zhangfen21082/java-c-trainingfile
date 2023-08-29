import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC {
    public static void main(String[] args) throws SQLException {

                    /************创建数据源对象:它描述了要访问的数据库是什么，在哪里 **************/

        /*
             1： DataSource来源标准库，是一个接口，而MysqlDataSource来源于MySQL驱动包
             2：每种数据库都会提供对应的类来实现DataSource接口（向上转型）
        */

        DataSource dataSource = new MysqlDataSource();

                  /************设置URL、用户名和密码 **************/

        /*
             1：DataSource服务于各种数据库，而MysqlDataSource只是服务于MySQL
             2： MySQL是一个C/S程序，要描述服务器的位置就必须指定服务器地址，所以需要
                向下转型，转成子类后调用MysqlDataSource中的setURL方法

             3：当然你也可以不用多态写法，写成下面这样
                    MysqlDataSource dataSource = new MysqlDataSource();
                    dataSource1.setURL();
               但是这样的写法会导致MysqlDataSource与项目耦合程度太高，
               因此未来在更换数据库时修改成本就会增加
             4：setURL中各字段含义如下
                        jdbc:mysql:  协议名称
                        127.0.0.1：IP地址，这是本地环回，即本机IP地址
                        3306：端口号
                        mysql_java：要访问的数据库名称
                        characterEncoding=utf8：客户端使用的字符集（注意要和服务器一致）
                        useSSL=false：设置连接不加密
                        serverTimezone=UTC：设置时区为全球标准时间

         */
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/mysql_java?characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("password");

                  /************与服务器建立连接**************/
        /*
            1：注意处理异常，因为有很多原因可能会导致连接建立失败

            2：使用Connection来表示连接，且注意Connection应该要使用JDBC(java.sql)下的Connection
            不要使用MySQL中的Connection
         */
        Connection connection = dataSource.getConnection();
        System.out.println(connection);  // 如果可以正常显示代表连接成功

                 /************构造SQL语句并进行预处理**************/
        /*
            1：使用高级语言操作数据库时，还是要通过SQL语句进行
            2：如果直接把 字符串发给数据库，数据库就得对其进行解析（耗时比较长）
            3：因此我们会把解析工作放在客户端进行，待客户端解析完成后直接把解析后的结果发送给数据库
            4：所以需要通过字符串描述待执行的SQL操作，然后构造PreparedStatement对象
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生学号");
        int Sid = sc.nextInt();
        System.out.println("请输入学生姓名");
        String Sname = sc.next();

        String sql = "insert into student values(?, ?)"; //注意拼接正确
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, Sid);
        statement.setString(2, Sname);

        /************执行SQL语句**************/

        /*
             1：executeUpdate 对应插入删除、修改语句，返回值表示这次SQL影响了多少行
             2：excuteQuery 对应查询语句，返回值是临时表数据
         */
        int n = statement.executeUpdate();
        System.out.println("n = " + n);

              /************释放资源**************/

        statement.close();
        connection.close();
    }
}
