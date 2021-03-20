package com.lagou.demo02.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForwardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("接收到了浏览器的请求...");
        // 向request对象中设置属性信息
        request.setAttribute("key1", "value1");
        // 转发，也就是让Web组件将任务转交给另外一个Web组件
        //RequestDispatcher requestDispatcher = request.getRequestDispatcher("/targetServlet");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("https://www.baidu.com/index.php?tn=monline_3_dg");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
