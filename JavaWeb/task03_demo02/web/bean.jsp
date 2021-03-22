<%@ page import="com.lagou.demo02.Student" %>
<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JavaBean组件的使用</title>
</head>
<body>

<%-- 表示创建Student类型的对象由student引用变量负责记录  有效范围是当前页面 --%>
<jsp:useBean id="student" scope="page" class="com.lagou.demo02.Student"/>
<%-- 表示将student对象中名字为id的属性值设置为1002 --%>
<jsp:setProperty name="student" property="id" value="1002"/>
<jsp:setProperty name="student" property="name" value="guanyu"/>

<%
    // 创建Student类型的对象并设置成员变量的数值
    //Student student = new Student();
    //student.setId(1001);
    //student.setName("zhangfei");
%>

<%--<%= "获取到的学号是：" + student.getId() %>   &lt;%&ndash; 1001 1002 &ndash;%&gt;
<%= "获取到的姓名是：" + student.getName() %> &lt;%&ndash; zhangfei guanyu &ndash;%&gt;--%>
学号是：<jsp:getProperty name="student" property="id"/><br/>
姓名是：<jsp:getProperty name="student" property="name"/><br/>
</body>
</html>
