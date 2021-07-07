<%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/7/4
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    这里是login.jsp页面，您需要登录<br/>
    <form action="http://localhost:8080/15_filter/loginServlet" method="get">
        用户名：<input type="text" name="username" /><br/>
        密码：<input type="password" name="password" /><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
