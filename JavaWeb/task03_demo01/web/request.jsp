<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request内置对象的使用</title>
</head>
<body>
<%
    String serverName = request.getServerName();
    System.out.println("获取到的服务器名称为：" + serverName);
    int serverPort = request.getServerPort();
    System.out.println("获取到的服务器端口号为：" + serverPort);
    // 通过内置对象设置属性信息，也就是存储数据
    request.setAttribute("name", "guanyu");
%>
<%-- 实现转发效果，也就是服务器跳转 --%>
<jsp:forward page="requestTarget.jsp"></jsp:forward>
</body>
</html>
