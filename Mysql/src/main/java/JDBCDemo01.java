import java.sql.*;

public class JDBCDemo01 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动(可省略)
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接 connection连接对象
        String url = "jdbc:mysql://localhost:3306/paotui?characterEncoding=UTF-8";
        Connection connection = DriverManager.getConnection(url, "root", "root");

        //3.获取语句执行平台 statement
        Statement statement = connection.createStatement();

        //3.通过statement对象的executeUpdate方法创建一张表
        String sql = "create table test(id int,name varchar(20),age int)";

        //返回值表示受影响的行数
        int i = statement.executeUpdate(sql);
        System.out.println(i);

        //3.2

        //关闭流
        statement.close();
        connection.close();
    }
}
