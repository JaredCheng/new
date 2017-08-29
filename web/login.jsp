<%--
  Created by IntelliJ IDEA.
  User: JerryCheng
  Date: 2017.8.9
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link rel="stylesheet" href="css/reset.css" />
    <link rel="stylesheet" href="css/login.css" />

    <script type="text/javascript">
        function changeImg() {
            var img = document.getElementById("img");
            img.src = "/login/authImage?date=" + new Date();
            ;
        }
    </script>
</head>
<body>
<div class="page">
    <div class="loginwarrp">
        <div class="logo">新闻管理系统</div>
        <div class="login_form">
            <form id="Login" name="Login" method="post"  action="UserAction_login">
                <li class="login-item">
                    <span>用户名：</span>
                    <input name="username" class="login_input">
                </li>
                <li class="login-item">
                    <span>密　码：</span>
                    <input name="password" class="login_input">
                </li>
                <li class="login-sub">
                    <input type="submit" name="Submit" value="登录" />
                </li>
            </form>
        </div>
    </div>
</div>
</body>
</html>
