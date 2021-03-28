<%@ page import="lyg.enetity.Manager" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: 李沅罡
  Date: 2021/3/28
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级管理系统查询结果</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<!-- 默认的导航条样式 -->
<div class="navbar navbar-default">
    <!-- 响应式的容器 -->
    <div class="container">
        <!-- 导航条的头部 -->
        <div class="navbar-header">
            <a href="#" class="navbar-brand">班级管理</a>
            <% Manager manager = (Manager) session.getAttribute("Manager");%>
            <a href="#" class="navbar-brand" style="text-align: center; margin-left: 100px">欢迎${sessionScope.Manager.mUsername}</a>
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
                <li > <a href="/MavenWeb/studentList"> <span class="glyphicon glyphicon-home"></span> 学员管理</a> </li>
                <li class="active"> <a href="classManage?cmd=showClazzes&pageNo=1"> <span class="glyphicon glyphicon-camera"></span> 班级管理</a> </li>
                <%--                <li> <a href="#"> <span class="glyphicon glyphicon-tint"></span> 竞争</a> </li>--%>
                <%--                <li> <a href="#"> <span class="glyphicon glyphicon-earphone"></span> 联系我们</a> </li>--%>
            </ul>
        </div>
    </div>
</div>

<div>
    <a href="classManage?cmd=showClazzes&pageNo=1" style="float: left;" >
        <button class="btn btn-primary" style="color: white">返回</button>
    </a>


</div>

<table class="table table-striped " id="collection">
    <thead>
    <tr>
        <th>班级ID</th>
        <th>班级名称</th>
        <th>年级</th>
        <th>班主任名称</th>
        <th>班级人数</th>
        <th>班级口号</th>
        <th>操作</th>
    </tr>
    </thead>

    <tbody>

    <%--        <% List classInfo = (List) request.getAttribute("classInfoList");--%>
    <%--            System.out.println(classInfo);--%>
    <%--        %>--%>
    <c:forEach items="${requestScope.classInfos}" var="classinfo" >
        <tr>
            <td >${classinfo.classId}</td>
            <td >${classinfo.className}</td>
            <td >${classinfo.grade}</td>
            <td>${classinfo.homeTeacherName}</td>
            <td>${classinfo.classNum}</td>
            <td>${classinfo.classSlogan}</td>
            <td>
                <a href="classManage?cmd=revise&classid=${classinfo.classId}" style="color: white"><submit class="btn btn-primary" >编辑</submit></a>
                <a href="classManage?cmd=delete&classId=${classinfo.classId}" style="color: white"><submit class="btn btn-primary" >删除</submit></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>


</table>




<script src="js/jquery-3.3.1.min.js"></script>



</body>
</html>
