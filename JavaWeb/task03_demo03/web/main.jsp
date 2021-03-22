<%@ page import="com.lagou.demo03.bean.User" %><%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
</head>
<body>
<h1>登录成功，欢迎<%= ((User)session.getAttribute("user")).getUserName() %>使用！</h1>
</body>
</html>
