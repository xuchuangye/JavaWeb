<%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/25
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Object name = request.getAttribute("name");
        out.print(name);
    %>
</body>
</html>
