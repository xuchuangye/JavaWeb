<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/24
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         isErrorPage="true"
         language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    这是一个b.jsp页面
    <br/>
    <!-- 输出整型 -->
    <%=
        12
    %>
    <br/>
    <!-- 输出浮点型 -->
    <%=
        12.12
    %>
    <br/>
    <!-- 输出字符串 -->
    <%=
        "abc"
    %>
    <br/>
    <!-- 输出对象 -->
    <%=
        new ArrayList<Integer>(){{add(1);};{add(2);}}
    %>
    <br/>
    <!-- _jspService()方法中的对象可以使用 -->
    <%=
        request.getParameter("username")
    %>
</body>
</html>
