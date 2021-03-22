<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext内置对象属性的获取</title>
</head>
<body>
<%= "获取到的pageContext内置对象中的属性值为：" + pageContext.getAttribute("name")%> <%-- null --%>
</body>
</html>
