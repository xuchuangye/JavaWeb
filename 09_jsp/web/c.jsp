<%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/24
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    这是一个c.jsp页面
    <!-- 代码脚本if语句 -->
    <!-- 可以多个jsp代码脚本组合成一个完整的Java语句 -->
    <%
        boolean isGood = true;
        if(isGood == true) {
    %>
        <h1>我好帅！！！</h1>
    <%
        } else {
    %>
        <h1>真的吗？</h1>
    <%
        }
    %>
    <!-- 代码脚本for循环语句 -->
    <!-- jsp代码脚本可以和表达式脚本组合使用 -->
    <table border="1" cellspacing="0">
    <%
        for (int i = 0; i < 10; i++) {
    %>
        <tr>
            <td>
                第<%=i%>行
            </td>
        </tr>
    <%

        }
    %>
    </table>
    <!-- 代码脚本_jspService()方法内的代码 -->
    <%
        String username = request.getParameter("username");
    %>
    <h1>username</h1>
    <%
        System.out.println(username);
    %>
</body>
</html>
