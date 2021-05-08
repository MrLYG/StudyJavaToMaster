<%--
  Created by IntelliJ IDEA.
  User: Szc.0713
  Date: 2020/6/21
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--form表单 该表单提交的请求方式为post类型--%>
    <form action="${pageContext.request.contextPath}/employee/addEmployee" method="post">
        员工name：<input type="text" name="emp_name"><br>
        部门id：<input type="text" name="dept_id">
        职位名：<input type="text" name="job_name">
        入职日期：<input type="text" name="join_date">
        电话：<input type="text" name="telephone">
        <input type="submit" value="增加员工">
    </form>






    <%--演示自定义类型转换器 : 错误的产生  2012/12/12 --%>
    <form action="${pageContext.request.contextPath}/user/converterParam" method="post">

        生日：<input type="text" name="birthday">
        <input type="submit" value="自定义类型转换器">
    </form>


    <%--引入jquery.js--%>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"/>





</body>
</html>
