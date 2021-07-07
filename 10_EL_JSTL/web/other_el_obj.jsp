<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: xuchuangye
  Date: 2021/6/26
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- param和paramValues对象主要是服务器从页面或者客户端获取信息 --%>
    输出param对象当中的所有元素 ${param}<br/>
    输出param对象当中key为username的value值：${param.username}<br/>
    输出param对象当中key为password的value值：${param.password}<br/>
    <%-- param对象只能获取元素多个值的第一个值 --%>
    输出param对象当中key为hobby的value值：${param.hobby}<br/>
    <%-- 获取多个值，需要使用paramValues对象--%>
    输出paramValues对象当中key为hobby的数组中第一个元素value值：${paramValues.hobby[0]}<br/>
    输出paramValues对象当中key为hobby的数组中第二个元素value值：${paramValues.hobby[1]}<br/>
    输出paramValues对象当中key为hobby的数组中第三个元素value值：${paramValues.hobby[2]}<br/>

    <%-- header和headerValues对象获取请求头的信息 --%>
    输出header对象当中的所有元素：${header}<br/>
    输出header对象当中key为["User-Agent"]的value值：${header["User-Agent"]}<br/>
    <%-- header对象只能获取多个key组成的数组的第一个key对应的value值 --%>
    输出header对象当中key为["Accept-Encoding"]的value值：${header["Accept-Encoding"]}<br/>
    <%-- headerValues对象可以获取多个key对应的value值 --%>
    输出headerValues对象当中key为["Accept-Encoding"]的数组当中第一个元素的value值：${headerValues["Accept-Encoding"][0]}<br/>

    <%-- cookie对象获取客户端的Cookie信息 --%>
    输出cookie对象当中的所有元素：${cookie}<br/>
    <%-- cookie对象当中的JSESSIONID也是一个对象--%>
    输出cookie对象当中key为JSESSIONID的value值：${cookie.JSESSIONID}<br/>
    输出cookie对象当中key为JSESSIONID的value值的name属性：${cookie.JSESSIONID.name}<br/>
    输出cookie对象当中key为JSESSIONID的value值的value属性：${cookie.JSESSIONID.value}<br/>

    <%-- initParam对象获取上下文的参数信息 --%>
    <%-- 在web.xml文件中配置完成信息之后必须重新部署或者重新启动服务器，才能生效 --%>
    输出initParam对象当中的所有元素：${initParam}<br/>
    输出initParam对象当中key为username的value值：${initParam.username}<br/>
    输出initParam对象当中key为url的value值：${initParam.url}<br/>
</body>
</html>
