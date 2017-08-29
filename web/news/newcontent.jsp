<%--
  Created by IntelliJ IDEA.
  User: JerryCheng
  Date: 2017.8.13
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加新闻</title>
    <link rel="stylesheet" href="../css/reset.css" />
    <link rel="stylesheet" href="../css/content.css" />
</head>
<body marginwidth="0" marginheight="0">
<div class="container">
    <div class="public-nav">您当前的位置：<a href="">新闻内容</a></div>
    <div class="public-content">
        <div class="public-content-header">
            <h3>新闻内容</h3>
        </div>
        <div class="public-content-cont">
            ${news[0].context}
        </div>
    </div>
</div>
<script src="../kingediter/kindeditor-all-min.js"></script>
<script>
    KindEditor.ready(function(K) {
        window.editor = K.create('#editor_id');
    });
</script>
</body>
</html>
