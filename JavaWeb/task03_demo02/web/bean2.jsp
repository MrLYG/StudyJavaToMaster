<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>实现前端页面传入过来参数的接收和设置</title>
</head>
<body>
<jsp:useBean id="student" scope="session" class="com.lagou.demo02.Student"/>
<jsp:setProperty name="student" property="id" param="id1"/>
<jsp:setProperty name="student" property="name" param="name1"/>
</body>
</html>
