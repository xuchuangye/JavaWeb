<%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/26
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("key1","pageContext1");
        pageContext.setAttribute("key2","pageContext2");
        request.setAttribute("key2","request");
        session.setAttribute("key2","session");
        application.setAttribute("key2","application");
    %>
    <%-- jsp输出相同key值时，会优先查找并使用域的范围最小的key所对应的value值 --%>
    ${key2}<br/><%-- pageContext2 --%>
    <%-- 如果想要输出对应域的元素的值，必须要在元素前面加上对应的域 --%>
    ${requestScope.key2}<br/><%-- request --%>
    ${sessionScope.key2}<br/><%-- session --%>
    ${applicationScope.key2}<br/><%-- application --%>
</body>
</html>
