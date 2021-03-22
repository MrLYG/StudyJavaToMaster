<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>reponse内置对象的使用</title>
</head>
<body>
<%
    // 表示每隔1秒刷新一次
    response.addHeader("refresh", "1");
    // 获取当前系统时间
    Date d1 = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String format = sdf.format(d1);
%>
<%= "当前时间为：" + format %>
</body>
</html>
