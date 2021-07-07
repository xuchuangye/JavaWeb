<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- 该页面只负责请求转发，转发到client/index.jsp页面 ，并且请求转发的方式是page分页业务--%>

<jsp:forward page="/client/bookServlet?action=page"></jsp:forward>