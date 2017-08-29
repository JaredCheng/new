<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JerryCheng
  Date: 2017.8.9
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title></title>
  <link rel="stylesheet" href="css/reset.css">
  <link rel="stylesheet" href="css/public.css">
</head>
<body>
<div class="public-header-warrp">
  <div class="public-header">
    <div class="content">
      <div class="public-header-logo"><a href=""><i>LOGO</i>
        <h3>aowin</h3></a></div>
      <div class="public-header-admin fr">
        <div class="public-header-fun fr">
         <c:if test="${empty sessionScope.username}"><a href="login.jsp" class="public-header-man">登陆</a></c:if>
         <c:if test="${ not empty sessionScope.username}">欢迎,${sessionScope.username} <a href="UserAction_logout" class="public-header-loginout">安全退出</a></c:if>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- 内容展示 -->
<div class="public-ifame mt20">
  <div class="content">
    <!-- 内容模块头 -->

    <div class="clearfix"></div>
    <!-- 左侧导航栏 -->
    <div class="public-ifame-leftnav">
      <div class="public-title-warrp">
        <div class="public-ifame-title ">
          <a href="index.jsp">首页</a>
        </div>
      </div>
      <ul class="left-nav-list">
        <li class="public-ifame-item">
          <a href="javascript:;">系统管理</a>
          <div class="ifame-item-sub">
            <ul>
              <li class="active"><a href="user/adduser.jsp" target="content">添加用户</a></li>
              <li><a href="UserAction_query" target="content">用户管理</a></li>
            </ul>
          </div>
        </li>
        <li class="public-ifame-item">
          <a href="javascript:;">新闻管理</a>
          <div class="ifame-item-sub">
            <ul>
              <li><a href="news/addnews.jsp" target="content">添加新闻</a></li>
              <li><a href="NewsAction_query" target="content">新闻管理</a></li>
            </ul>
          </div>
        </li>


      </ul>
    </div>
    <!-- 右侧内容展示部分 -->
    <div class="public-ifame-content">
      <iframe name="content" src="welcome.jsp" frameborder="0" id="mainframe" scrolling="yes" marginheight="0" marginwidth="0" width="100%" style="height: 700px;"></iframe>
    </div>
  </div>
</div>
<script src="js/jquery.min.js"></script>
<script>
    $().ready(function(){
        var item = $(".public-ifame-item");

        for(var i=0; i < item.length; i++){
            $(item[i]).on('click',function(){
                $(".ifame-item-sub").hide();
                if($(this.lastElementChild).css('display') == 'block'){
                    $(this.lastElementChild).hide()
                    $(".ifame-item-sub li").removeClass("active");
                }else{
                    $(this.lastElementChild).show();
                    $(".ifame-item-sub li").on('click',function(){
                        $(".ifame-item-sub li").removeClass("active");
                        $(this).addClass("active");
                    });
                }
            });
        }
    });
</script>
</body>
</html>
