<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/26
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("emptyNull",null);
        request.setAttribute("emptyString","");
        request.setAttribute("emptyArray",new Object[]{});
        request.setAttribute("emptyList",new ArrayList<>());
        request.setAttribute("emptyMap",new HashMap<String,Integer>());
    %>
    <%-- 值为null值时，为空 --%>
    ${empty emptyNull}<br/>
    <%-- 值为空串时，为空 --%>
    ${empty emptyString}<br/>
    <%-- Object类型的数组，长度为零时为空 --%>
    ${empty emptyArray}<br/>
    <%-- list集合，元素个数为零时为空 --%>
    ${empty emptyList}<br/>
    <%-- map集合，元素个数为零时为空 --%>
    ${empty emptyMap}<br/>
    <%-- 三元运算 --%>
    ${15 > 14 ? false : 14 > 13 ? true : false}<%-- false --%>
</body>
</html>
