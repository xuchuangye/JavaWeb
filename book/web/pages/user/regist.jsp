<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%-- 静态包含base标签，css样式，jQuery文件 --%>
    <%@include file="/pages/common/head.jsp"%>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
    <script type="text/javascript">
        $(function () {
            //用户名输入框绑定失去焦点事件
            $("#username").blur(function () {
                //添加AJAX请求
                let username = this.value;
                //alert(username);
                $.getJSON("http://localhost:8080/book/userServlet","action=ajaxExistsUsername&username=" + username,function (data) {
                    if(data.existsUsername){
                        $(".errorMsg").text("用户名已存在！");
                    }else {
                        $(".errorMsg").text("用户名可用！");
                    }
                });
            });

            //给验证码绑定单击事件
            $("#code_img").click(function () {
                this.src = "${basePath}kaptcha.jpg?d=" + new Date();
            });

            //给注册按钮绑定单击事件
            $("#sub_btn").bind("click", function () {
                //验证用户名字母数字下划线5到12位
                //1.获取用户名输入框当中的内容
                let usernameText = $("#username").val();
                //2.创建正则表达式对象
                let regexpUser = /^\w{5,12}$/;
                //3.使用test验证
                let userIsSuccess = regexpUser.test(usernameText);
                //4.给用户提示信息
                if (!userIsSuccess) {
                    $(".errorMsg").text("用户名输入不合法！");
                    return false;
                }

                //验证用户密码字母数字下划线5到12位
                //1.获取用户密码输入框当中的内容
                let passwordText = $("#password").val();
                //2.创建正则表达式对象
                let regexpPassword = /^\w{5,12}$/;
                //3.使用test验证正则表达式
                let passwordIsSuccess = regexpPassword.test(passwordText);
                //4.给用户提示信息
                if (!passwordIsSuccess) {
                    $(".errorMsg").text("用户密码输入不合法！");
                    return false;
                }
                //验证确认密码，和密码相同
                //1.获取确认密码输入框当中的内容
                let repwdText = $("#repwd").val();
                //2.和密码比较
                if (repwdText != passwordText) {
                    //3.给用户提示信息
                    $(".errorMsg").text("确认密码和密码不一致！");
                    return false;
                }

                //邮箱验证
                //1.获取邮箱输入框当中的内容
                let emailText = $("#email").val();
                //2.创建正则表达式对象
                let regexpEmail = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                //3.使用test验证正则表达式
                let emailIsSuccess = regexpEmail.test(emailText);
                //4.给用户提示信息
                if(!emailIsSuccess) {
                    $(".errorMsg").text("邮箱输入不合法！");
                    return false;
                }
                //验证码，现在只验证用户已输入，因为没讲到服务器，验证码生成
                let codeText = $("#code").val();
                //去除前后空格
                let trimCodeText = $.trim(codeText);
                //判断是否为空或者空字符串
                if (trimCodeText == null ||  trimCodeText == "") {
                    $(".errorMsg").text("验证码不能为空！");
                    return false;
                }

                $(".errorMsg").text("");
            });
        });
    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">
                        ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="register"/>
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               autocomplete="off" tabindex="1"
                               name="username" id="username"
                               value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码"
                               autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址"
                               autocomplete="off" tabindex="1"
                               name="email" id="email"
                               value="${requestScope.email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 100px;" id="code" name="code"/>
                        <img id="code_img" alt="" src="kaptcha.jpg"
                             style="float: right; margin-right: 40px; width: 120px; height: 40px"/>
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%-- 静态包含，包含页脚信息 --%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>