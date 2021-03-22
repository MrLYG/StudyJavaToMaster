<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试变量的声明和打印</title>
    <%!
        int ia; // 这是一个全局变量

        public void show() {
            System.out.println("这是全局方法！");
        }

        public class MyClass {
            {
                System.out.println("这是一个全局类哦！");
            }
        }
    %>

    <%
        int ib = 20;  // 这是一个局部变量

        for (int i = 0; i < 3; i++) {
            System.out.println("随便放入Java程序代码吧！");
        }
    %>
</head>
<body>
<%= ia+1 %>  <%-- 1 --%>
<%= ib %>    <%-- 20 --%>
<%= "我就暂时写到这里吧！"%>  <%-- 我就暂时写到这里吧！ --%>
</body>
</html>
