package com.lagou.xml05;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {

    //查询所有员工信息
    public static void main(String[] args) throws SQLException {

        //1.获取连接
        Connection connection = JDBCUtils.getConnection();

        //2.获取Statement 对象 执行SQL
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employee");

        //3.处理结果集
        while(resultSet.next()){

            String name = resultSet.getString("ename");
            System.out.println("员工的姓名: " + name);
        }

        //4.关闭资源
        resultSet.close();
        statement.close();
        connection.close();

    }

}
