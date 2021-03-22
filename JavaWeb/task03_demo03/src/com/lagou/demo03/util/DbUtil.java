package com.lagou.demo03.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbUtil {
    private static String jdbcName;   // 用于描述驱动信息
    private static String dbUrl;      // 用于描述URL信息
    private static String dbUserName; // 用户描述用户名信息
    private static String dbPassword; // 用户描述密码信息

    // 进行静态成员的初始化操作
    static {
        jdbcName = "com.mysql.jdbc.Driver";
        dbUrl = "jdbc:mysql://localhost:3306/db_web";
        dbUserName = "root";
        dbPassword = "123456";
        try {
            Class.forName(jdbcName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return con;
    }

    /**
     * 关闭连接
     * @param con
     * @throws SQLException
     */
    public static void closeResource(Connection con, PreparedStatement psts) throws SQLException {
        if (null != con) {
            con.close();
        }
        if (null != psts) {
            psts.close();
        }
    }
}
