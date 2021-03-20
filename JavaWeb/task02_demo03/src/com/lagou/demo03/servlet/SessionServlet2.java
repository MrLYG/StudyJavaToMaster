package com.lagou.demo03.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionServlet2", urlPatterns = "/session2")
public class SessionServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // 1.设置属性名和属性值
        session.setAttribute("name", "machao");
        // 2.获取指定属性名对应的属性值
        System.out.println("获取到的属性值为：" + session.getAttribute("name")); // machao
        // 3.删除指定的属性名
        session.removeAttribute("name");
        // 4.获取指定属性名对应的属性值
        System.out.println("获取到的属性值为：" + session.getAttribute("name")); // null
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
