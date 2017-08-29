<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JerryCheng
  Date: 2017.8.13
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>新闻管理</title>
    <link rel="stylesheet" href="../css/reset.css" />
    <link rel="stylesheet" href="../css/content.css" />
</head>
<body marginwidth="0" marginheight="0">
<div class="container">
    <div class="public-nav">您当前的位置：<a href="">管理新闻</a></div>
    <div class="public-content">
        <div class="public-content-cont">

            <form  action="NewsAction_selectquery" class="public-cont-table" method="post">
                <label >新闻编号</label>
                <input name="onenew.newid" >
                <label >新闻标题</label>
                <input name="onenew.title">
                <label >创建时间</label>
                <input name="onenew.createTime">
                <label >新闻级别</label>
                <input name="onenew.newlevel">
                <input type="submit" value="搜索">
            </form>
            <table class="public-cont-table">
                <tr>
                    <th >新闻编号</th>
                    <th >新闻标题</th>
                    <th >新闻作者</th>
                    <th >创建时间</th>
                    <th >新闻图片</th>
                    <th >新闻级别</th>
                    <th >操作</th>
                </tr>

                <c:forEach items="${news}" var="onenew">
                    <tr>
                        <td align="center">${onenew.newid}</td>
                        <td align="center"><a href="NewsAction_querydetail?newid=${onenew.newid}">${onenew.title}</a></td>
                        <td align="center">${onenew.author}</td>
                        <td align="center">${onenew.createTime}</td>
                        <td align="center">${onenew.pic}  <img src="${onenew.pic}" width=20px height=20px></td>
                        <td align="center">${onenew.newlevel}</td>
                        <td align="center"><span><a href="NewsAction_editnew?newid=${onenew.newid}" style="display: inline-block">修改</a>
                            <a href="NewsAction_del?newid=${onenew.newid}" style="display: inline-block">删除</a></span>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="page">
                <form action="" method="get">
                    共<span>42</span>个站点
                    <a href="">首页</a>
                    <a href="">上一页</a>
                    <a href="">下一页</a>
                    第<span style="color:red;font-weight:600">12</span>页
                    共<span style="color:red;font-weight:600">120</span>页
                    <input type="text" class="page-input">
                    <input type="submit" class="page-btn" value="跳转">
                </form>
            </div>
     </div>
    </div>
</div>
</div>
</body>
</html>
