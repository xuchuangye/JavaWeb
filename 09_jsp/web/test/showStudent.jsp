<%@ page import="com.atguigu.pojo.StudentList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.atguigu.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/25
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tezt2</title>
    <style type="text/css">
        table {
            border: 1px blue solid;
            width: 600px;
            border-collapse: collapse;
        }
        td,th {
            border: 1px blue solid;
        }
    </style>
</head>
<body>
    <% List<Student> stuList = (List<Student>) request.getAttribute("stuList"); %>
    <%--  遍历输出10个学生信息到表格中  --%>
    <table>
        <tr>
            <th colspan="4">学生信息</th>
        </tr>
        <tr>
            <td>学生姓名</td>
            <td>学生编号</td>
            <td>学生年龄</td>
            <td>学生电话</td>
        </tr>
        <% for (Student stu : stuList) {%>
            <tr>
                <td><%= stu.getId() %></td>
                <td><%= stu.getName() %></td>
                <td><%= stu.getAge() %></td>
                <td><%= stu.getPhone() %></td>
            </tr>
        <%}%>
    </table>
</body>
</html>
