<%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/24
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>这是一个scope.jsp页面</h1>
    <%-- jsp代码脚本，设置给各个域对象添加值 --%>
    <%
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
    %>
    pageContext域的属性值：<%= pageContext.getAttribute("key")%><br/>
    request域的属性值：<%= request.getAttribute("key")%><br/>
    session域的属性值：<%= session.getAttribute("key")%><br/>
    application域的属性值：<%= application.getAttribute("key")%><br/>
    <%--
        request.getRequestDispatcher("/scope2.servlet").forward(request,response);
    --%>
    <%-- servlet.forword请求转发
     page设置请求转发的资源路径 --%>
    <jsp:forward page="/scope2.jsp"></jsp:forward>
</body>
</html>
