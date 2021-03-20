package com.lagou.demo03.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieServlet4", urlPatterns = "/cookie4")
public class CookieServlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.创建Cookie信息
        Cookie cookie = new Cookie("name", "liubei");
        // 2.获取Cookie信息的默认使用期限
        int maxAge = cookie.getMaxAge();
        System.out.println("该Cookie的默认使用期限是：" + maxAge);
        // 3.修改Cookie信息的使用期限
        // 正数表示在指定的秒数后失效   负数表示浏览器关闭后失效   0表示马上失效
        //cookie.setMaxAge(0);
        cookie.setMaxAge(60*10);
        // 4.添加到响应信息中
        response.addCookie(cookie);
        System.out.println("设置Cookie的生命周期成功！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
