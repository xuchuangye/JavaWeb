<%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/26
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- setAttribute()方法，如果属性存在，那么就是设置；如果属性不存在，那么就是添加 --%>
    <%
        pageContext.setAttribute("req",request);
        pageContext.setAttribute("ses",session);
    %>
    <%-- 1.协议: --%>
    jsp表达式脚本方式获取协议：<%= request.getScheme() %><br/>
    EL表达式方式获取协议：${req.scheme}<br/>
    <%-- 2.服务器ip: --%>
    jsp表达式脚本方式获取服务器IP：<%= request.getServerName() %><br/>
    EL表达式方式获取服务器IP：${req.serverName}<br/>
    <%-- 3.服务器端口号: --%>
    jsp表达式脚本方式获取服务器端口号：<%= request.getServerPort() %><br/>
    EL表达式方式获取服务器端口号：${req.serverPort}<br/>
    <%-- 4.获取工程路径: --%>
    jsp表达式脚本方式获取工程路径：<%= request.getContextPath() %><br/>
    EL表达式方式获取工程路径：${req.contextPath}<br/>
    <%-- 5.获取请求方法: --%>
    jsp表达式脚本方式获取请求方法：<%= request.getMethod() %><br/>
    EL表达式方式获取请求方法：${req.method}<br/>
    <%-- 6.获取客户端ip地址: --%>
    jsp表达式脚本方式获取客户端IP地址：<%= request.getRemoteHost() %><br/>
    EL表达式方式获取客户端IP地址：${req.remoteHost}<br/>
    <%-- 7.获取会话的id编号: --%>
    jsp表达式脚本方式获取会话的id编号：<%= session.getId() %><br/>
    EL表达式方式获取会话的id编号：${ses.id}<br/>
</body>
</html>
