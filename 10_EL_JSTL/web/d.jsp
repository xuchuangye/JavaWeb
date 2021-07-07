<%@ page import="com.atguigu.pojo.Person" %><%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/26
  Time: 8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- EL表达式-运算 --%>
    <%
        Person person = new Person();
        request.setAttribute("per", person);
    %>
    <%-- 关系运算 --%>
    ${per.age == per.age} 或者 ${per.age eq per.age}<br/>
    ${per.age != per.age} 或者 ${per.age ne per.age}<br/>
    ${per.age < per.age} 或者 ${per.age lt per.age}<br/>
    ${per.age > per.age} 或者 ${per.age gt per.age}<br/>
    ${per.age <= per.age} 或者 ${per.age le per.age}<br/>
    ${per.age >= per.age} 或者 ${per.age ge per.age}<br/>

    <%-- 逻辑运算 --%>
    ${per.age > 18 && per.age < 17} 或者 ${per.age > 18 and per.age < 17}<br/>
    ${per.age > 18 || per.age < 17} 或者 ${per.age > 18 or per.age < 17}<br/>
    ${!(per.age > 18 || per.age < 17)} 或者 ${not(per.age > 18 or per.age < 17)}<br/>

    <%-- 算数运算 --%>
    ${per.age + per.id}
    ${per.age - per.id}
    ${per.age * per.id}
    <%-- EL表达式除法计算结果为浮点型 --%>
    ${per.age / per.id} 或者 ${per.age div per.id}<br/>
    ${per.age % 10} 或者 ${per.age mod 10}<br/>
</body>
</html>
