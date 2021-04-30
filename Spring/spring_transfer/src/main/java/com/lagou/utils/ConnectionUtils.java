package com.lagou.utils;

/*
    连接工具类：从数据源中获取一个连接，并且将获取到的连接与线程进行绑定
       ThreadLocal : 线程内部的存储类，可以在指定的线程内存储数据 key:threadLocal(当前线程)   value:任意类型的值 Connection

 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class ConnectionUtils {

    @Autowired
    private DataSource dataSource;

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();


    /*
        获取当前线程上绑定连接：如果获取到的连接为空，那么就要从数据源中获取连接，并且放到ThreadLocal中（绑定到当前线程）
     */
    public  Connection getThreadConnection(){

        // 1. 先从ThreadLocal上获取连接
        Connection connection = threadLocal.get();

        // 2. 判断当前线程中是否是有Connection
        if(connection == null){
            // 3. 从数据源中获取一个连接，并且存入ThreadLocal中
            try {
                // 不为null
                connection = dataSource.getConnection();

                threadLocal.set(connection);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return  connection;
    }


    /*
        解除当前线程的连接绑定
     */
    public void  removeThreadConnection(){
        threadLocal.remove();

    }





}
