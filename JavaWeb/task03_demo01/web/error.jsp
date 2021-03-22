<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>异常处理的页面</title>
</head>
<body>
<%
    if (exception != null) {
        out.println("异常的错误信息为：" + exception.getMessage());
    }
%>
</body>
</html>
