<%@ page import="lyg.enetity.Manager" %>
<%@ page import="lyg.enetity.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 李沅罡
  Date: 2021/3/23
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <title>学员管理系统</title>
</head>
<body>
<%--sId;--%>
<%--private String sName;--%>
<%--private String sGender;--%>
<%--private String sBorn;--%>
<%--private String sEmail;--%>
<%--private String sPassword;--%>
<%--private String sNote;--%>
<% Manager manager = (Manager) session.getAttribute("Manager");%>
<h3 style="height: 50px;text-align: center">欢迎<%= manager.getmUsername() %></h3>
<div>
    <a href="studentServlet?cmd=add" style="float: left;margin-left: 20px;" >
        <button class="btn btn-primary" style="color: white">新增</button>
    </a>
    <form action="studentServlet?cmd=search" method="post" style="margin-left: 30px;">

        <input type="submit" class="btn btn-primary" value="查询">
        </input>
        <input type="text" name="sName" placeholder="请输入全名查询">
    </form>


</div>

<table class="table table-striped " id="collection">
    <thead>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>出生日期</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>
    </thead>



    <tbody>
    <% List<Student> students = (List<Student>) request.getAttribute("students");%>
    <% for (Student s: students ) { %>
        <tr>

            <td ><%=s.getsId()%></td>
            <td class="name"><%=s.getsName()%></td>
            <td class="gender"><%=s.getsGender()%></td>
            <td><%=s.getsBorn().substring(0,10)%></td>
            <td><%=s.getsEmail()%></td>
            <td>

                <a href="studentServlet?cmd=revise&studentid=<%=s.getsId()%>" style="color: white"><submit class="btn btn-primary" >编辑</submit></a>
                <a href="studentServlet?cmd=delete&sId=<%=s.getsId()%>" style="color: white"><submit class="btn btn-primary" >删除</submit></a>
            </td>


        </tr>

    <%}%>

<%--    <tr >--%>
<%--        <td><input type="checkbox" > </td>--%>
<%--        <td class="number">1001</td>--%>
<%--        <td class="name">张三</td>--%>
<%--        <td>女</td>--%>
<%--        <td>1234</td>--%>
<%--        <td>29</td>--%>
<%--        <td>1991-1-1</td>--%>
<%--    </tr>--%>
<%--    <tr >--%>
<%--        <td><input type="checkbox"> </td>--%>
<%--        <td class="number">1002</td>--%>
<%--        <td class="name">李四</td>--%>
<%--        <td>男</td>--%>
<%--        <td>1234</td>--%>
<%--        <td>28</td>--%>
<%--        <td>1992-2-2</td>--%>
<%--    </tr>--%>
<%--    <tr >--%>
<%--        <td><input type="checkbox"> </td>--%>
<%--        <td class="number">1003</td>--%>
<%--        <td class="name">王五</td>--%>
<%--        <td>女</td>--%>
<%--        <td>1234</td>--%>
<%--        <td>27</td>--%>
<%--        <td>1993-3-3</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td><input type="checkbox"> </td>--%>
<%--        <td class="number">1004</td>--%>
<%--        <td class="name">赵六</td>--%>
<%--        <td>女</td>--%>
<%--        <td>1234</td>--%>
<%--        <td>26</td>--%>
<%--        <td>1994-4-4</td>--%>
<%--    </tr>--%>

    </tbody>


</table>
</body>
</html>
