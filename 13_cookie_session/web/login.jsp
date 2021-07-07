<%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/7/1
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- cookie是11个隐藏域对象之一 --%>
<%-- ${cookie.username.value} --%>
<form action="http://localhost:8080/13_cookie_session/loginServlet" method="get">
    用户名：<input type="text" name="username" value="${cookie.username.value}"/>
    密  码：<input type="password" name="password" />
    <input type="submit" value="登录" />
</form>
</body>
</html>
