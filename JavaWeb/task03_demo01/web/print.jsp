<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>实现表格的绘制</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>salary</td>
    </tr>
    <%
        for (int i = 1; i < 6; i++) {
    %>
    <tr>
        <td> <%= i %> </td>
        <td> <%= i %> </td>
        <td> <%= i %> </td>
        <td> <%= i %> </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
