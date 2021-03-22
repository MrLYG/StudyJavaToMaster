<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>实现JavaBean组件中对象属性值的打印</title>
</head>
<body>
<jsp:useBean id="student" scope="session" class="com.lagou.demo02.Student"/>
<%-- 获取名字为student对象中属性为id的数值并打印 --%>
经过参数赋值后获取到的学号是：<jsp:getProperty name="student" property="id"/><br/>
经过参数赋值后获取到的姓名是：<jsp:getProperty name="student" property="name"/><br/>
</body>
</html>
