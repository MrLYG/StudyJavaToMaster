package com.lagou.demo03.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionServlet3", urlPatterns = "/session3")
public class SessionServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取Session对象
        HttpSession session = request.getSession();
        // 2.获取对象的默认失效时间并打印
        int maxInactiveInterval = session.getMaxInactiveInterval();
        System.out.println("获取到的失效时间为：" + maxInactiveInterval); // 1800
        // 3.修改实现时间后重新获取并打印
        session.setMaxInactiveInterval(1200);
        maxInactiveInterval = session.getMaxInactiveInterval();
        System.out.println("获取到的失效时间为：" + maxInactiveInterval); // 1200
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
