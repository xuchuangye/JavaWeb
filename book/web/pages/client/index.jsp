<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%-- 静态包含base标签，css样式，jQuery文件 --%>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            //给加入购物车绑定单击事件
            $(".addToCart").click(function () {
                //attr设置或者获取被选元素的属性值
                let bookid = $(this).attr("bookid");

                $.getJSON("http:///localhost:8080/book/cartServlet","action=ajaxAddItem&id=" + bookid,function (data) {
                    //console.log(data);
                    $("#cartTotalCount").text("您的购物车中有" + data.totalCount +"件商品");
                    $("#cartLastName").text(data.lastName);
                });
                //让购物车知道添加的是哪一个商品
                //location.href = "http:///localhost:8080/book/cartServlet?action=addItem&id=" + bookid;
            });
            //给删除的a标签添加删除提示操作
            /*$("a.deleteClass").click(function () {
                //confirm提示函数
                //确定返回true,取消返回false
                //this表示当前的dom对象,$(this)转换成jQuery对象
                return confirm("您确定要删除[" + $(this).parent().parent().find("td:first").text() + "]吗？");
            });*/
            $("#searchPageBtn").click(function () {
                let pageNo = $("#pn_input").val();
                let pageTotal = ${requestScope.page.pageTotal};
                if (pageNo >= 1 && pageNo <= pageTotal) {
                    //href属性可读可写
                    location.href = "${pageScope.basePath}client/bookServlet?action=page&pageNo=" + pageNo;
                }
            });
        });
    </script>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">网上书城</span>
    <div>
        <c:if test="${empty sessionScope.user.username}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <c:if test="${not empty sessionScope.user.username}">
            <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
            <a href="pages/order/order.jsp">我的订单</a>
            <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
        </c:if>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/bookServlet" method="get">
                <input type="hidden" name="action" value="pageByPrice" />
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询"/>
            </form>
        </div>
        <div style="text-align: center">

            <c:if test="${empty sessionScope.cart.items}">
                <span id="cartTotalCount">您的购物车中有${empty sessionScope.cart.totalCount ? 0 : sessionScope.cart.totalCount}件商品</span>
                <%-- 购物车为空的时候 --%>
                <div>
                    <span id="cartLastName" style="color: red">当前购物车为空</span>
                </div>
            </c:if>
            <c:if test="${not empty sessionScope.cart.items}">
                <span id="cartTotalCount">您的购物车中有${empty sessionScope.cart.totalCount ? 0 : sessionScope.cart.totalCount}件商品</span>

                <%-- 购物车非空的时候 --%>
                <div>
                    您刚刚将<span id="cartLastName" style="color: red">${sessionScope.lastName}</span>加入到了购物车中
                </div>
            </c:if>
        </div>


        <c:forEach items="${requestScope.page.items}" var="book">
        <div class="b_list">
            <div class="img_div">
                <img class="book_img" alt="" src="${book.imgPath}"/>
            </div>
            <div class="book_info">
                <div class="book_name">
                    <span class="sp1">书名:</span>
                    <span class="sp2">${book.name}</span>
                </div>
                <div class="book_author">
                    <span class="sp1">作者:</span>
                    <span class="sp2">${book.author}</span>
                </div>
                <div class="book_price">
                    <span class="sp1">价格:</span>
                    <span class="sp2">${book.price}</span>
                </div>
                <div class="book_sales">
                    <span class="sp1">销量:</span>
                    <span class="sp2">
                            ${book.sales}
                    </span>
                </div>
                <div class="book_amount">
                    <span class="sp1">库存:</span>
                    <span class="sp2">${book.stock}</span>
                </div>
                <div class="book_add">
                    <button bookid="${book.id}" class="addToCart">加入购物车</button>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>

    <%-- 导入common目录下的page_nav.jsp当中的分页条内容 --%>
    <%@include file="/pages/common/page_nav.jsp" %>


</div>
<%-- 静态包含，包含页脚信息 --%>
<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>