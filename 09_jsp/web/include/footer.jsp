<%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/25
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>footer</title>
</head>
<body>
    页脚信息<br/>
    修改一下页脚信息
    <%-- 被动态包含的jsp页面可以获取动态包含当中的参数信息 --%>
    <% out.write(request.getParameter("username"));%>
</body>
</html>
