
<%--
  Created by IntelliJ IDEA.
  User: JerryCheng
  Date: 2017.8.9
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台欢迎页</title>
    <link rel="stylesheet" href="../css/reset.css" />
    <link rel="stylesheet" href="../css/content.css" />
</head>
<body marginwidth="0" marginheight="0">
<div class="container">
    <div class="public-nav">您当前的位置：<a href="">系统管理</a>><a href="">用户管理</a></div>
    <div class="public-content">
        <div class="public-content-header">
            <h3>用户管理</h3>
        </div>
        <form  action="UserAction_selectquery" class="public-cont-table" method="post">
                <label >用户名</label>
                <input name="user.username" >
                <label >编号</label>
                <input name="user.id">
                <label >地址</label>
                <input name="user.addr">
                <label >等级</label>
                <input name="user.glass">
                <label >联系方式</label>
                <input name="user.tel">
            <input type="submit" value="搜索">
        </form>
        <div class="public-content-cont">

            <table class="public-cont-table">
                <tr>
                    <th >用户名</th>
                    <th >密码</th>
                    <th >用户编号</th>
                    <th >地址</th>
                    <th >级别</th>
                    <th >联系方式</th>
                    <th >权限</th>
                    <th >操作</th>
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td align="center">${user.username}</td>
                        <td align="center">${user.password}</td>
                        <td align="center">${user.id}</td>
                        <td align="center">${user.addr}</td>
                        <td align="center">${user.glass}</td>
                        <td align="center">${user.tel}</td>
                        <td align="center">${user.auth}</td>
                        <td ><span><a href="UserAction_edit?username=${user.username}" style="display: inline-block">修改</a>
                            <a href="UserAction_del?username=${user.username}" style="display: inline-block">删除</a></span></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
