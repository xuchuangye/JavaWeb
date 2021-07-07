<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/26
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forEach</title>
    <style type="text/css">
        ol {
            list-style-type: none;
        }
    </style>
</head>
<body>
    <%--
      <c:forEach>标签用于遍历输出
      begin属性设置开始的索引
      end属性设置结束的索引
      var属性设置循环的变量
    --%>
    <ol>
        <c:forEach begin="1" end="10" var="i">
            <li>第${i}行</li>
        </c:forEach>
    </ol>
    <table border="1" cellspacing="0">
        <c:forEach begin="1" end="10" var="i">
            <tr>
                <td>第${i}行</td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <%-- 遍历数组 --%>
    <%
        request.setAttribute("arr",new String[] {"123","456","789"});
    %>
    <%-- items属性表示遍历的数据源，var表示遍历到当前的数据 --%>
    <c:forEach items="${requestScope.arr}" var="i">
        ${i}<br/>
    </c:forEach>

    <%-- 遍历Map集合 --%>
    <%
        Map<String,String> map = new HashMap<String,String>();
        map.put("key1","value1");
        map.put("key2","value3");
        map.put("key3","value4");
        request.setAttribute("map",map);
    %>
    <%-- items表示遍历的数据源，var表示当前正在遍历的数据 --%>
    <c:forEach items="${requestScope.map}" var="entry">
        <h1>${entry.key} = ${entry.value}</h1>
    </c:forEach>

    <%-- 遍历自定义类Student，编号，用户名，密码，年龄，电话 --%>
    <%
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"xcy","666",18,"185346456546"));
        list.add(new Student(2,"wzg","678",20,"185423564236"));
        list.add(new Student(3,"rgt","333",22,"185343424256"));
        request.setAttribute("list",list);
    %>
    <table border="1" cellspacing="0">
        <tr>
            <th colspan="6">学生信息</th>
        </tr>
        <tr>
            <td>学生编号</td>
            <td>学生姓名</td>
            <td>学生密码</td>
            <td>学生年龄</td>
            <td>学生电话</td>
            <td>操作</td>
        </tr>
        <c:forEach begin="0" end="2" step="1" varStatus="status" items="${requestScope.list}" var="stu">
            <tr>
                <td>${stu.id}</td>
                <td>${stu.username}</td>
                <td>${stu.password}</td>
                <td>${stu.age}</td>
                <td>${stu.phone}</td>
                <td>${status.current}</td>
                <td>${status.index}</td>
                <td>${status.count}</td>
                <td>${status.first}</td>
                <td>${status.last}</td>
                <td>${status.begin}</td>
                <td>${status.end}</td>
                <td>${status.step}</td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>
