<%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/25
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% request.setAttribute("key","value");%>
    <%-- 输出存在的值 --%>
    jsp的表达式脚本输出值：<%=request.getAttribute("key")%><br/>
    EL表达式输出值：${key}<br/>
    <%-- 输出不存在的值 --%>
    <%-- jsp表达式脚本输出的是null字符串 --%>
    <%-- jsp的表达式脚本输出值：<%=request.getAttribute("key1")%><br/> --%>
    jsp的表达式脚本输出值达到EL表达式的效果：<%= request.getAttribute("key1") ==null ? "" : request.getAttribute("key1")%><br/>
    <%-- EL表达式输出的是空串 --%>
    EL表达式输出值：${key1}
</body>
</html>
