package com.lagou.test;

import org.junit.Test;

import java.sql.*;

public class JDBCTest {

    @Test
    public void test1() throws SQLException, ClassNotFoundException {

        //1.注册驱动      存在编译期依赖：耦合重的体现
       // DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        // 编译期不依赖，运行期才依赖
        Class.forName("com.mysql.jdb.Driver");

        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///mybatis_db","root","123");

        //3.定义sql
        String sql = "select * from user";

        //4.获取预编译对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //5.执行sql,得到结果
        ResultSet resultSet = preparedStatement.executeQuery();

        //6.遍历结果
        while (resultSet.next()){
            System.out.println(resultSet.getString("username"));
        }

        //7.关闭资源
        resultSet.close();
        preparedStatement.close();
        connection.close();


    }


}
