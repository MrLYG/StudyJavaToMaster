package com.lagou.demo03.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieServlet5", urlPatterns = "/cookie5")
public class CookieServlet5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.创建Cookie对象并指定数值
        //Cookie cookie = new Cookie("name", "zhaoyun");
        Cookie cookie = new Cookie("name", "huangzhong");
        // 3.修改Cookie的路径信息
        cookie.setPath(request.getContextPath() + "/hello");
        // 2.添加到响应信息中
        response.addCookie(cookie);
        System.out.println("设置Cookie路径成功！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
