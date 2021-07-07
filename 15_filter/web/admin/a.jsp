<%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/7/4
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  这是a.jsp页面
    <%
        System.out.println("a.jsp被执行了");
        Object user = request.getAttribute("user");
        if (user == null) {
        	request.getRequestDispatcher("/login.jsp").forward(request,response);
        	return;
        }
    %>
</body>
</html>
