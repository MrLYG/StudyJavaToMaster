package com.lagou.demo02.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("接收到了浏览器的请求...");
        // 重定向，也就是给浏览器发送一个新的位置
        //response.sendRedirect("target.html");
        response.sendRedirect("https://www.baidu.com/index.php?tn=monline_3_dg");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
