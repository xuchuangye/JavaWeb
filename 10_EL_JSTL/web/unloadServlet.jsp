<%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/27
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/10_EL_JSTL/" />
</head>
<body>
<form action="unloadServlet" enctype="multipart/form-data" method="post">
    用户名：<input type="text" name="username"/><br/>
    头像：<input type="file" name="photo"/><br/>
    <input type="submit" value="上传"><br/>
</form>
</body>
</html>
