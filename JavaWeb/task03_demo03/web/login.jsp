<%@ page contentType="text/html;charset=utf-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>实现简单的登录功能</title>
</head>
<body>
<form action="login" method="post">
  用户名：<input type="text" name="userName"/><br/>
  密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="text" name="password"/><br/>
  <span style="color: red"><%= request.getAttribute("error")==null?"":request.getAttribute("error")%></span><br/>
  <input type="submit" value="登录"/>
</form>
</body>
</html>