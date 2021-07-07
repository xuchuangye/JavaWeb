<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%-- 静态包含base标签，css样式，jQuery文件 --%>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            //给修改数量添加失去焦点事件--->换成内容改变事件会更好
            $(".update_btn").change(function () {
                //获取商品名称
                let name = $(this).parent().parent().find("td:first").text();

                let id = $(this).attr("bookid");
                //获取商品数量
                let count = this.value;
                if (confirm("您确定要将商品[" + name +"]的数量修改为" + count + "吗？")){
                    //确定，发起请求给服务器进行修改
                    location.href = "http://localhost:8080/book/cartServlet?action=updateCount&count=" + count +"&id=" + id;
                }else {
                    //取消，恢复商品数量
                    //defaultValue是表单项的dom对象的属性，它表示默认的value值
                    this.value = this.defaultValue;
                }
            });
            //给删除按钮绑定单击事件
            $("a.delete_item_btn").click(function () {
                let name = $(this).parent().parent().find("td:first").text();
                return confirm("您确定要删除该[" + name + "]商品吗？");
            });

            //给清空购物车绑定单击事件
            $("a.is_clear_btn").click(function () {
                return confirm("您确定要清空购物车吗？");
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%-- 静态包含，登录成功之后的菜单 --%>
    <%@ include file="/pages/common/login_success_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:if test="${not empty sessionScope.cart.items}">
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td>
                        <input class="update_btn" style="width: 50px;text-align: center" type="text"
                               bookid="${entry.value.id}"
                               value="${entry.value.count}"/>
                    </td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a href="http://localhost:8080/book/cartServlet?action=deleteItem&id=${entry.value.id}"
                           class="delete_item_btn">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a style="text-decoration: none;color: red"
                                   href="index.jsp">亲！当前购物车没有商品哦！快去和小伙伴们愉快的购物吧！</a></td>
            </tr>
        </c:if>

    </table>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
        <span class="cart_span">购物车中共有<span
                class="b_count">${empty sessionScope.cart.totalCount ? 0 : sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span
                    class="b_price">${empty sessionScope.cart.totalPrice ? 0 : sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a class="is_clear_btn" href="http://localhost:8080/book/cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>
</div>

<%-- 静态包含，包含页脚信息 --%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>