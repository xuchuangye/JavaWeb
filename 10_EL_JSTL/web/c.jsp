<%@ page import="com.atguigu.pojo.Person" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/25
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person = new Person();
        person.setId(100);
        String[] strings = {"123", "456", "789"};
        person.setArr(strings);
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        person.setList(integers);
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        person.setMap(map);
        request.setAttribute("per",person);
    %>
    EL表达式输出类：${per}<br/>
    EL表达式输出类的属性id的值：${per.id}<br/>
    EL表达式输出类的String类型的数组arr：${per.arr}<br/>
    EL表达式输出类的String类型的数组arr具体的某一个值：${per.arr[1]}<br/>
    EL表达式输出类的Integer类型的list集合：${per.list}<br/>
    EL表达式输出类的Integer类型的list集合具体的某一个值：${per.list[2]}<br/>
    EL表达式输出类的key为String,value为Integer类型的map：${per.map}<br/>
    EL表达式输出类的key为String,value为Integer类型的map具体某一个key所对应的值：${per.map.a}<br/>
    EL表达式输出类的静态常量属性age的值：${per.age}<br/>
</body>
</html>
