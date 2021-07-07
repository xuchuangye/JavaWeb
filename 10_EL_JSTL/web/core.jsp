<%-- taglib指令，引入标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/26
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>core</title>

</head>
<body>
    <%-- core中的set标签，保存数据到域中 --%>
    <%-- scope属性设置将数据保存到哪个域,默认是pageContext域 --%>
    <%-- request代表Request域 --%>
    <%-- session代表Session域 --%>
    <%-- application代表Application域 --%>
    <%-- var属性设置key是多少 --%>
    <%-- value属性设置value是多少 --%>
    配置之前：${requestScope.abc}<br/>
    <c:set scope="request" var="abc" value="abcValue" />
    配置之后：${requestScope.abc}<br/>

    <%-- core中的if标签，用来做if判断 --%>
    <%-- test属性表示判断的条件，使用EL表达式进行输出 --%>
    <c:if test="${ 18 == 18}">
        <h1>18等于18</h1>
    </c:if>
    <c:if test="${ 18 != 18}">
        <h1>18不等于18</h1>
    </c:if>

    <%-- core中的choose,when,otherwise标签，用来判断多个条件的语句 --%>
    <%-- choose标签表示开始选择条件判断 --%>
    <%-- when标签表示每一种判断情况 --%>
        <%-- test属性表示当前判断情况的值 --%>
    <%-- otherwise标签表示其它的判断情况 --%>
    <%
        request.setAttribute("score",50);
    %>
    <%-- 使用<c:choose><c:when><c:otherwise>标签需要注意的事项 --%>
    <%-- 不能在其内部使用html注释，只能使用jsp注释 --%>
    <%-- 使用<c:when>标签时，必须以<c:choose>标签作为其父标签 --%>
    <c:choose>
        <%-- 这是jsp注释 --%>
        <c:when test="${score >= 90}">
            <h2>成绩优秀</h2>
        </c:when>
        <c:when test="${score >= 80}">
            <h2>成绩良好</h2>
        </c:when>
        <c:when test="${score >= 70}">
            <h2>成绩不错</h2>
        </c:when>
        <c:when test="${score >= 60}">
            <h2>成绩合格</h2>
        </c:when>
        <c:otherwise>
            <c:choose>
                <c:when test="${score >= 50}">
                    <h2>成绩不理想，请继续努力</h2>
                </c:when>
                <c:when test="${score >= 40}">
                    <h2>成绩不合格，请继续努力</h2>
                </c:when>
                <c:when test="${score >= 30}">
                    <h2>成绩比较差，请继续努力</h2>
                </c:when>
                <c:otherwise>
                    <h2>继续加油，不放弃</h2>
                </c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>
</body>
</html>
