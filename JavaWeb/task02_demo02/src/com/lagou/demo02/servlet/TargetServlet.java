package com.lagou.demo02.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TargetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("转发过来了...");
        // 获取request对象中的属性值判断是否共享
        Object key1 = request.getAttribute("key1");
        System.out.println("获取到的属性值为：" + key1); // value1
        // 通过打印流向页面写入转发成功的信息
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<h1>转发成功！</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
