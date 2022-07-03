<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%@include file="/pages/common/header.jsp"%>
    <script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
    <script type="text/javascript">
        $(function () {
            $("#code_img").click(function () {
                this.src="${basePath}kaptcha.jpg?d="+new Date();
            })

            $("#sub_btn").click(function () {
                //验证用户名
                var username = $("#username").val();
                var usernamepatt=/^\w{5,12}$/;
                if (!usernamepatt.test(username)){
                    //提示非法
                    $("span.errorMsg").text("用户名不合法");
                    return false;
                }
                //验证密码
                var password = $("#password").val();
                var passwordpatt=/^\w{5,12}$/;
                if (!passwordpatt.test(password)){
                    //提示非法
                    $("span.errorMsg").text("密码不合法");
                    return false;
                }
                //验证确认密码
                var repwd = $("#repwd").val();
//                alert(repwd==password);
                if (repwd!=password){
                    $("span.errorMsg").text("两次密码不一致");
                    return false;
                }
                //验证邮箱
                var email = $("#email").val();
                var emailpatt=/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if (!emailpatt.test(email)){
                    $("span.errorMsg").text("邮箱不合法");
                    return false;
                }
                //验证验证码
                var code = $("#code").val();
                var trimcode = $.trim(code);
                if (trimcode==null||trimcode==""){
                    $("span.errorMsg").text("验证码不能为空");
                    return false;
                }
                $("span.errorMsg").text("");
            });
        })
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
                    <h1>注册会员</h1>
                    <span class="errorMsg">
                        <%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label for="username">用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               autocomplete="off" tabindex="1" name="username" id="username"
                        value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址"
                               autocomplete="off" tabindex="1" name="email" id="email"
                        value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 105px;"  name="code" id="code"/>
                        <img id="code_img" alt="" src="kaptcha.jpg" style="float: right;width:150px; margin-right: 20px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>