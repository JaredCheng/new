<%--
  Created by IntelliJ IDEA.
  User: JerryCheng
  Date: 2017.8.9
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台欢迎页</title>
    <link rel="stylesheet" href="../css/reset.css" />
    <link rel="stylesheet" href="../css/content.css" />
</head>
<body marginwidth="0" marginheight="0">
<div class="container">
    <div class="public-nav">您当前的位置：<a href="">系统管理</a>><a href="">添加用户</a></div>
    <div class="public-content">
        <form action="UserAction_add" method="post" >

                <div class="form-group mt0">
                    <label >用户名</label>
                    <input name="user.username" >
                </div>
                <div class="form-group mt0">
                    <label >密码</label>
                    <input name="user.password" >
                </div>
                <div class="form-group mt0">
                    <label >编号</label>
                    <input name="user.id">
                </div>
                <div class="form-group mt0">
                    <label >地址</label>
                    <input name="user.addr">
                </div>
                <div class="form-group mt0">
                    <label >等级</label>
                    <input name="user.glass">
                </div>
                <div class="form-group mt0">
                    <label >联系方式</label>
                    <input name="user.tel">
                </div>
                <div class="form-group mt0">
                    <label >权限</label>
                    <input type="radio" name="user.auth" value="管理">管理
                    <input type="radio" name="user.auth" value="国际">国际
                    <input type="radio" name="user.auth" value="娱乐">娱乐
                    <input type="radio" name="user.auth" value="体育">体育
                    <input type="radio" name="user.auth" value="民生">民生
                </div>
                <div class="form-group mt0" style="text-align:center;margin-top:15px;">
                    <input type="submit" class="sub-btn" value="提   交">
                </div>
        </form>
    </div>
</div>
</body>
</html>
