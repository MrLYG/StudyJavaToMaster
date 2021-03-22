<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session内置对象的使用</title>
</head>
<body>
<%
    session.setAttribute("name", "liubei");
    System.out.println("session内置对象中的数据设置成功！");
%>
</body>
</html>
