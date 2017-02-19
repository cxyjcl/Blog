<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set  var="visit"  value="123456789"  scope="session"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>日志</title>
    <link href="./static/css/content.css" rel="stylesheet">
    <link rel="stylesheet" href="./static/frame/Font/css/font-awesome.min.css">
    <style>
       .back {
            margin: 0 auto;
           text-align: center;
       }
    </style>
</head>
<body>
<!--导航栏-->
<div class="navbar">
    <div class="navbar-inner">
        <ul>
            <li><a href="/Blog/index">首页</a></li>
            <li class="active"><a href="/Blog/diary">日志</a></li>
            <li><a href="/Blog/photograph">相册</a></li>
            <li><a href="/Blog/message">留言板</a></li>
            <li><a href="#">个人档</a></li>
        </ul>
            <div class="login">
            <c:if test="${sessionScope.user eq null}"><a href="/Blog/view/login.jsp" class="alogin">登录</a></c:if>
            <c:if test="${sessionScope.user ne null}"><a href="/Blog/exit" class="alogin">退出</a><a><img src="${sessionScope.user.touxiang}"/></a></c:if>
            </div>
    </div>
</div>
<!--日志-->
<div class="container">
    <div class="head">
        <div class="content-header"><input type='text' value="${page.title}" readonly="true"/></div>
        <div class="content-footer">
            <span><fmt:formatDate value="${page.time}" pattern="yyyy-MM-dd"/></span>
            <a>围观:<em>${page.click}</em></a>
        </div>
    </div>
    <div class="referer"><a href="${referer}">返回上一级</a><i class="icon-arrow-right"></i></div>
    <div class="content">
    ${page.content}
    </div>
</div>
</body>
</html>
