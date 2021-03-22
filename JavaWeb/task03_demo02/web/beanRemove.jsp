<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>实现JavaBean组件数据的删除</title>
</head>
<body>
<%
    // 表示从session对象中删除名字为student的属性
    session.removeAttribute("student");
%>
<%= "删除数据成功！" %>
</body>
</html>
