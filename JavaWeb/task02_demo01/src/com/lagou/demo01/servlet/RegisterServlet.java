package com.lagou.demo01.servlet;

import com.lagou.demo01.dao.UserDao;
import com.lagou.demo01.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求对象中保存的用户名和密码信息
        String userName = request.getParameter("userName");
        System.out.println("获取到的用户名为：" + userName);
        String password = request.getParameter("password");
        System.out.println("获取到的密码为：" + password);
        // 2.将接受到的用户名和密码信息打包成用户对象交给DAO层进行处理
        User user = new User(userName, password);
        UserDao userDao = new UserDao();
        int res = userDao.createUser(user);
        // 3.将处理结果响应到浏览器
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (1 == res) {
            System.out.println("注册成功！");
            writer.write("<h1>注册成功！</h1>");
        } else {
            writer.write("<h1>注册失败！</h1>");
        }
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
