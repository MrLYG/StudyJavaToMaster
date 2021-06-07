<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/27
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>

<form action="/register">
    <p>username: <input name="username"></p>
    <p>password: <input name="password"></p>
    <p>phone: <input name="phone"></p>
    <p><input type="button" id="btn" value="register"></p>
</form>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
    var btn = document.getElementById("btn");
    btn.οnclick = function () {
        alert("hello world");
    }

    $("#btn").on("click", function () {
        alert("click")
        $.post("http://localhost:8085/lagou_dubbo_web/register", $("form").serialize(), function (result) {
            alert(result)
        }, "json");
    });
</script>
</body>
</html>
