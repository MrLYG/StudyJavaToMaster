<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取session内置对象中的数据</title>
</head>
<body>
<%= "获取到的属性值为：" + session.getAttribute("name")%>
</body>
</html>
