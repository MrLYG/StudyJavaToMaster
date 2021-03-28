<%@ page import="lyg.enetity.Manager" %>
<%@ page import="lyg.enetity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
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

<div>
    <a href="studentServlet?cmd=add" style="float: left;" >
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




    <% //定义每页的长度
        double pageNum = 10;
    %>
    <% List<Student> students = (List<Student>) request.getAttribute("students");%>
    <% Map<Integer,List<Student> > studentsMap = new HashMap<>(); %>
    <%
        int i = 0;
        boolean flag = true;
        int t = 0;
        while(flag){
            List<Student> studentsTemp = new ArrayList<>();
            for (int j = t; j < (i+1)*pageNum; j++) {
                if(j>=students.size()){
                    flag = false;
                    break;
                }
                studentsTemp.add(students.get(j));
            }
            t+=pageNum;
            studentsMap.put(i,studentsTemp);
            i++;

        }

    %>
    <tbody>
    <% for (Student s: studentsMap.get(0) ) { %>
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


    </tbody>


</table>
<div style="text-align: center;height: 50px;width: 2000px">
    <ul class="pagination" style="text-align: center">

        <%--        <li class="previous"> <a href="#"> &laquo; </a> </li>--%>

        <% for (int x = 1; x<=Math.ceil(students.size()/pageNum);x++){ %>
        <li ><a onclick="page<%=x%>()"> <%=x%></a>  </li>
        <%}%>
        <%--        <li class="next"> <a href="#">&raquo;</a> </li>--%>
    </ul>
</div>

<script src="js/jquery-3.3.1.min.js"></script>
<script>
    function page1(){

        var newTr = $("<tbody>" +
            <% for (Student s: studentsMap.get(0) ) { %>
            "<tr>"+
            "<td ><%=s.getsId()%></td>"+
        "<td class='name'><%=s.getsName()%></td>"+
        "<td class='gender'><%=s.getsGender()%></td>"+
        "<td><%=s.getsBorn().substring(0,10)%></td>"+
        "<td><%=s.getsEmail()%></td>"+
        "<td>"+

        "<a href='studentServlet?cmd=revise&studentid=<%=s.getsId()%>' style='color: white'><submit class='btn btn-primary' >编辑</submit></a>"+
        "<a href='studentServlet?cmd=delete&sId=<%=s.getsId()%>' style='color: white'><submit class='btn btn-primary' >删除</submit></a>"+
        "</td>"+


        "</tr>"+

        <%}%>
        "</tbody>"
        )
        $("#collection tbody").remove();
        $("#collection thead").after(newTr);
        console.log();
    }
    function page2(){

        var newTr = $("<tbody>" +
            <% for (Student s: studentsMap.get(1) ) { %>
            "<tr>"+
            "<td ><%=s.getsId()%></td>"+
            "<td class='name'><%=s.getsName()%></td>"+
            "<td class='gender'><%=s.getsGender()%></td>"+
            "<td><%=s.getsBorn().substring(0,10)%></td>"+
            "<td><%=s.getsEmail()%></td>"+
            "<td>"+

            "<a href='studentServlet?cmd=revise&studentid=<%=s.getsId()%>' style='color: white'><submit class='btn btn-primary' >编辑</submit></a>"+
            "<a href='studentServlet?cmd=delete&sId=<%=s.getsId()%>' style='color: white'><submit class='btn btn-primary' >删除</submit></a>"+
            "</td>"+


            "</tr>"+

            <%}%>
            "</tbody>"
        )
        $("#collection tbody").remove();
        $("#collection thead").after(newTr);
        console.log();
    }
    function page3(){

        var newTr = $("<tbody>" +
            <% for (Student s: studentsMap.get(1) ) { %>
            "<tr>"+
            "<td ><%=s.getsId()%></td>"+
            "<td class='name'><%=s.getsName()%></td>"+
            "<td class='gender'><%=s.getsGender()%></td>"+
            "<td><%=s.getsBorn().substring(0,10)%></td>"+
            "<td><%=s.getsEmail()%></td>"+
            "<td>"+

            "<a href='studentServlet?cmd=revise&studentid=<%=s.getsId()%>' style='color: white'><submit class='btn btn-primary' >编辑</submit></a>"+
            "<a href='studentServlet?cmd=delete&sId=<%=s.getsId()%>' style='color: white'><submit class='btn btn-primary' >删除</submit></a>"+
            "</td>"+


            "</tr>"+

            <%}%>
            "</tbody>"
        )
        $("#collection tbody").remove();
        $("#collection thead").after(newTr);
        console.log();
    }
    function page4(){

        var newTr = $("<tbody>" +
            <% for (Student s: studentsMap.get(1) ) { %>
            "<tr>"+
            "<td ><%=s.getsId()%></td>"+
            "<td class='name'><%=s.getsName()%></td>"+
            "<td class='gender'><%=s.getsGender()%></td>"+
            "<td><%=s.getsBorn().substring(0,10)%></td>"+
            "<td><%=s.getsEmail()%></td>"+
            "<td>"+

            "<a href='studentServlet?cmd=revise&studentid=<%=s.getsId()%>' style='color: white'><submit class='btn btn-primary' >编辑</submit></a>"+
            "<a href='studentServlet?cmd=delete&sId=<%=s.getsId()%>' style='color: white'><submit class='btn btn-primary' >删除</submit></a>"+
            "</td>"+


            "</tr>"+

            <%}%>
            "</tbody>"
        )
        $("#collection tbody").remove();
        $("#collection thead").after(newTr);
        console.log();
    }


</script>
</body>
</html>
