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
    <h1>这是一个scope2.jsp页面</h1>
    <%-- 测试各个域对象的获取值的范围 --%>
    pageContext域的属性值：<%= pageContext.getAttribute("key")%><br/>
    request域的属性值：<%= request.getAttribute("key")%><br/>
    session域的属性值：<%= session.getAttribute("key")%><br/>
    application域的属性值：<%= application.getAttribute("key")%><br/>
</body>
</html>
