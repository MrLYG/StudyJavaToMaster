package com.lagou.demo03.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieServlet2", urlPatterns = "/cookie2")
public class CookieServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取客户端发来的Cookie信息并打印出来
        Cookie[] cookies = request.getCookies();
        System.out.println("获取到的Cookie信息有：");
        for (Cookie tc : cookies) {
            System.out.println(tc.getName() + "对应的值为：" + tc.getValue());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
