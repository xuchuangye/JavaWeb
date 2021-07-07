<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/24
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    这是一个a.jsp页面
    <!-- 声明属性  -->
    <%!
        private String name;
        private Integer id;
        private static Map<String,Object> map;
    %>
    <!-- 声明静态代码块 -->
    <%!
        static {
            map = new HashMap<String,Object>();
            map.put("key1","value1");
            map.put("key2","value2");
            map.put("key3","value3");
        }
    %>
    <!-- 声明类方法 -->
    <%!
        private void print() {
            System.out.println("类方法");
        }
    %>
    <!-- 声明内部类 -->
    <%!
        public class A {
        	private String age;
        	private Integer ClassId;
        }
    %>
</body>
</html>
