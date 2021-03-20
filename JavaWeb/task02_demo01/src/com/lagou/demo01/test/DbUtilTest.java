package com.lagou.demo01.test;

import com.lagou.demo01.util.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class DbUtilTest {

    public static void main(String[] args) {

        Connection connection = null;
        try {
            connection = DbUtil.getConnection();
            System.out.println("连接数据库成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /*try {
                DbUtil.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
        }
    }
}
