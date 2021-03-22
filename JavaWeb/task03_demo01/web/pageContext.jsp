<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext内置对象的使用</title>
</head>
<body>
<%
    pageContext.setAttribute("name", "huangzhong");
    System.out.println("pageContext内置对象中的数据设置成功！");
%>
<%= "获取到的pageContext内置对象中的属性值为：" + pageContext.getAttribute("name")%>
</body>
</html>
