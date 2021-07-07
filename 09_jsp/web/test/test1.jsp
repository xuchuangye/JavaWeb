<%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/25
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test1</title>
    <style type="text/css">

    </style>
</head>
<body>
<h1> 九九乘法表 </h1>
    <table>
    <%for (int i = 1; i <= 9 ; i++) {%>
        <tr>
            <%for (int j = 1; j <= i; j++) { %>
            <td>
                <%= j + "*" + i + "=" + i*j %>
            </td>
            <%}%>
        </tr>
    <%}%>
    </table>
</body>
</html>
