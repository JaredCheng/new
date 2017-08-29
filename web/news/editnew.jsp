<%--
  Created by IntelliJ IDEA.
  User: JerryCheng
  Date: 2017.8.13
  Time: 23:50
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
    <div class="public-nav">您当前的位置：<a href="">修改新闻</a></div>
    <div class="public-content">
        <div class="public-content-header">
            <h3>修改新闻</h3>
        </div>
        <div class="public-content-cont">
            <form action="NewsAction_edited" method="post">
                <div class="form-group">
                    <label for="">新闻编号</label>
                    <input class="form-input-txt" name="onenew.newid" value="${requestScope.news[0].newid}" readonly>
                </div>
                <div class="form-group">
                    <label for="">新闻标题</label>
                    <input class="form-input-txt" name="onenew.title" value="${requestScope.news[0].title}">
                </div>
                <div class="form-group">
                    <label for="">新闻分类</label>
                    <select class="form-input-txt" name="onenew.newlevel" value="${requestScope.news[0].newlevel}">
                        <option value="1" style="width: 20px;">体育</option>
                        <option value="2" style="width: 20px;">民生</option>
                        <option value="3" style="width: 20px;">国际</option>
                        <option value="4" style="width: 20px;">娱乐</option>
                    </select>
                </div>
                <div class="form-group">
                    <input type="file" class="form-input-file" name="onenew.pic" value="${requestScope.news[0].pic}"/><input type="submit" class="form-input-file"/>
                </div>

                <div class="clearfix"></div>


                <div class="form-group">
                    <label for="">新闻的内容</label>
                    <textarea id="editor_id" name="onenew.context"  class="form-input-textara" style="width:700px;height:300px;">
                        ${requestScope.news[0].context}
                    </textarea>
                </div>
                <div class="form-group" style="margin-left:150px;">
                    <input type="submit" class="sub-btn" value="提  交" />
                    <input type="reset" class="sub-btn" value="重  置" />
                </div>
            </form>
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
