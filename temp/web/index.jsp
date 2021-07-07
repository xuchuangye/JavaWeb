<%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/7/2
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style type="text/css">
        input[name=code] {
            width: 80px;
        }
        img {
            width: 100px;
            height: 30px;
        }
    </style>
</head>
<body>
<form action="http://localhost:8080/temp/registServlet" method="get">
    用户名：<input type="text" name="username"/><br/>
    验证码：<input type="text" name="code"/>
    <img src="http://localhost:8080/temp/kaptcha.jpg" alt=""/><br/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
