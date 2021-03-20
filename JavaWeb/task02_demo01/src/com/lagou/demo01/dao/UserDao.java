package com.lagou.demo01.dao;

import com.lagou.demo01.model.User;
import com.lagou.demo01.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    public int createUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 1.获取连接
            connection = DbUtil.getConnection();
            // 2.准备sql语句
            String sql = "insert into t_user values(null, ?, ?)";
            // 3.获取PrepareStatement类型的引用
            preparedStatement = connection.prepareStatement(sql);
            // 4.向问号所占的位置设置数据
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            // 5.执行sql语句
            int row = preparedStatement.executeUpdate();
            return row; // 执行成功
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6.关闭资源
            try {
                DbUtil.closeConnection(connection, preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0; // 执行失败
    }
}
