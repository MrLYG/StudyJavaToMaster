package com.lagou.xml05;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {

    //1.定义字符串变量 保存连接信息
    public static String DRIVERNAME;
    public static String URL;
    public static String USER;
    public static String PASSWORD;

    //2.静态代码块
    static{
        //使用 XPath语法 对xml中的数据进行读取
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read("H:\\jdbc_work\\xml_task03\\src\\com\\lagou\\xml05\\jdbc-config.xml");

            //1.获取驱动名称
            Node driver = document.selectSingleNode("/jdbc/property[@name='driverClass']");
            DRIVERNAME = driver.getText();

            //2.获取URL
            Node url = document.selectSingleNode("/jdbc/property[@name='jdbcUrl']");
            URL = url.getText();

            //3.获取用户名
            Node user = document.selectSingleNode("/jdbc/property[@name='user']");
            USER = user.getText();

            //4.获取密码
            Node password = document.selectSingleNode("/jdbc/property[@name='password']");
            PASSWORD = password.getText();

            //注册驱动
            Class.forName(DRIVERNAME);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //获取连接
    public static Connection getConnection(){

        try {

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
