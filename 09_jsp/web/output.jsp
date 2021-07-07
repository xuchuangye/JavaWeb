<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/24
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        out.write("out输出1<br/>");
        //out进行刷新操作
        out.flush();

        response.getWriter().write("response输出1<br/>");
        response.getWriter().write("response输出2<br/>");

        out.write("out输出2<br/>");
    --%>
    <%
        out.write(22);
    %>
    <br/>
    <%
        out.print(12);
    %>
</body>
</html>
