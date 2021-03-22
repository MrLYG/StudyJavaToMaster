<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>application内置对象的使用</title>
</head>
<body>
<%
    application.setAttribute("name", "zhaoyun");
    System.out.println("application内置对象中的数据设置成功！");
%>
</body>
</html>
