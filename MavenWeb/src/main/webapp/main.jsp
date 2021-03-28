<%--
  Created by IntelliJ IDEA.
  User: 李沅罡
  Date: 2021/3/28
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学员管理系统</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<!-- 默认的导航条样式 -->
<div class="navbar navbar-default">
    <!-- 响应式的容器 -->
    <div class="container">
        <!-- 导航条的头部 -->
        <div class="navbar-header">
            <a href="#" class="navbar-brand">学员管理系统</a>
            <% Manager manager = (Manager) session.getAttribute("Manager");%>
            <a href="#" class="navbar-brand" style="text-align: center; margin-left: 100px">欢迎<%= manager.getmUsername() %></a>
            <!-- data-toggle="collapse"  数据切换的事件，特效是折叠-->
            <!-- data-target="#nav"  折叠效果的目标是下面的#nav容器-->
            <button class="navbar-toggle" data-toggle="collapse" data-target="#nav">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <!-- 导航项 -->
        <div id="nav" class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"> <a href="/MavenWeb/studentList"> <span class="glyphicon glyphicon-home"></span> 学员管理</a> </li>
                <li> <a href="classManage?cmd=showClazzes&pageNo=1"> <span class="glyphicon glyphicon-camera"></span> 班级管理</a> </li>
<%--                <li> <a href="#"> <span class="glyphicon glyphicon-tint"></span> 竞争</a> </li>--%>
<%--                <li> <a href="#"> <span class="glyphicon glyphicon-earphone"></span> 联系我们</a> </li>--%>
            </ul>
        </div>
    </div>
</div>
<%@include file="StudentManage.jsp"%>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>

