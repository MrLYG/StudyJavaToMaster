<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>out内置对象的使用</title>
</head>
<body>
<%
    out.println("<h1>");
    out.println("Hello World!");
    out.println("</h1>");
    //out.close();

    int bufferSize = out.getBufferSize();
    System.out.println("缓冲区的总大小是：" + bufferSize);
    int remaining = out.getRemaining();
    System.out.println("缓冲区的剩余字节数为：" + remaining);
    System.out.println("已经使用的字节数为：" + (bufferSize - remaining));

    out.clear(); // 清除缓冲区  数据不会输出
    remaining = out.getRemaining();
    System.out.println("缓冲区的剩余字节数为：" + remaining);
%>
</body>
</html>
