<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/26
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        HashMap<String, String> map = new HashMap<>();
        map.put("a.a.a","aaaValue");
        map.put("b+b+b","bbbValue");
        map.put("c-c-c","cccValue");

        request.setAttribute("map",map);
    %>

    ${map}<br/>
    ${map["a.a.a"]}<br/>
    ${map["b+b+b"]}<br/>
    ${map["c-c-c"]}<br/>
</body>
</html>
