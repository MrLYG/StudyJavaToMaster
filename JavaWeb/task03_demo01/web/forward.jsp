<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP页面的转发实现</title>
</head>
<body>
<jsp:forward page="target.jsp">
    <jsp:param name="name" value="zhangfei"/>
</jsp:forward>
</body>
</html>
