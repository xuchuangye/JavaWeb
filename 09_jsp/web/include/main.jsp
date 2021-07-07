<%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/25
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
    头部信息<br/>
    主体内容<br/>
    <%-- 静态包含include
     file指定jsp的资源路径
     斜杠/ 服务器解析为http://localhost:8080/工程路径/--%>
    <%-- <%@include file="/include/footer.servlet"%> --%>



    <%-- 动态包含injsp.include --%>
    <%-- 动态代码会把被包含的jsp页面翻译成java代码 --%>
    <%-- 动态代码底层代码使用如下代码去调用被包含的jsp页面执行输出 --%>
    <%-- org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/include/footer.servlet", out, false); --%>
    <%-- 动态包含可以传递参数信息 --%>
    <jsp:include page="/include/footer.jsp">
        <jsp:param name="username" value="root"/>
        <jsp:param name="password" value="691020"/>
    </jsp:include>
</body>
</html>
