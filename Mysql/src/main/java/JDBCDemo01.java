import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemo01 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动(可省略)
        Class.forName("com.mysql.jdbc.driver");
        //2.获取连接 connection连接对象
        String url = "jdbc:mysql://localhost:3306/paotui?characterEncoding=UTF-8";
        Connection connection = DriverManager.getConnection(url, "root", "root");

        System.out.println(connection);
    }
}
