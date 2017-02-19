<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="visit"  value="123456789"  scope="session"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>相册</title>
    <script src="./static/js/jquery-2.0.3.min.js"></script>
    <link href="./static/css/screen.css" rel="stylesheet" type="text/css">
    <link href="./static/css/ma5gallery.css" rel="stylesheet" type="text/css">
    <script src="./static/js/ma5gallery.js"></script>
    <script src="./static/js/functions.js"></script>
    <link href="./static/css/photo.css" rel="stylesheet" type="text/css">
</head>
<body>
<!--导航栏-->
<div class="navbar">
    <div class="navbar-inner">
        <ul>
            <li><a href="/Blog/index">首页</a></li>
            <li><a href="/Blog/diary">日志</a></li>
            <li class="active"><a href="#">相册</a></li>
            <li><a href="/Blog/message">留言板</a></li>
            <li><a href="#">个人档</a></li>
        </ul>
            <div class="login">
            	<c:if test="${sessionScope.user eq null}"><a href="/Blog/view/login.jsp" class="alogin">登录</a></c:if>
            	<c:if test="${sessionScope.user ne null}"><a href="/Blog/exit" class="alogin">退出</a><a><img src="${sessionScope.user.touxiang}"/></a></c:if>
            </div>
    </div>
</div>
<!--图片-->
<div class="container">
    <div class="header">
        <p><h3>&nbsp;相册</h3></p>
        <hr/>
    </div>
    <div class="content">
    <c:forEach var="photobean" items="${photo.photoList}">
    <div class="inline">
<figure class="gallery-item">
    <img src="${photobean.photo}" alt="">
    <figcaption>${photobean.name}</figcaption>
</figure>
<p class="text-center character">${photobean.name}</p>
<p class="text-center"><fmt:formatDate value="${photobean.time}" pattern="yyyy-MM-dd"/></p>
</div>
</c:forEach>
    </div>
           <div class="content">
               <ul class="pagination">
               <c:choose>
               		<c:when test="${photo.totalRecored<=10}">
               			<c:set var="begin" value="1"></c:set>
               			<c:set var="end" value="${photo.totalRecored}"></c:set>
               		</c:when>
               		<c:otherwise>
               			<c:set var="begin" value="${photo.photoCode-4}"></c:set>
               			<c:set var="end" value="${photo.photoCode+5}"></c:set>
	               <c:if test="${begin<1}">
	    				<c:set var="begin" value="1"/>
	    				<c:set var="end" value="10"/>
	               </c:if>
	               <c:if test="${end>photo.totalRecored}">
	    				<c:set var="begin" value="${photo.totalRecored-9}"/>
	    				<c:set var="end" value="${photo.totalRecored}"/>
	               </c:if>
               </c:otherwise>
             </c:choose>
              		<c:if test="${photo.photoCode==1}">
                    	<li><a href="#" >&laquo;</a></li>              		
               		</c:if>
                   <c:if test="${photo.photoCode!=1}">
                    		<li><a href="/Blog/photograph?photoCode=${photo.photoCode-1}" >&laquo;</a></li>         		
               		</c:if>
               		
		        		<c:forEach begin="${begin}" end="${end}" var="i">
		        		<c:choose>
		        			<c:when test="${i eq photo.photoCode}">
		        				 <li><a href="#" class="nowpage">${i}</a></li>
		        			</c:when>
		        			<c:otherwise>
		        			    	<li><a href="/Blog/photograph?photoCode=${i}">${i}</a></li>
		        			</c:otherwise>
		        		</c:choose>
		        		</c:forEach>
        		<c:if test="${photo.photoCode==photo.totalRecored}">
        			<li><a href="#">&raquo;</a></li>
        		</c:if>
        		<c:if test="${photo.photoCode!=photo.totalRecored}">
           			<li><a href="/Blog/photograph?photoCode=${photo.photoCode+1}">&raquo;</a></li>     				
        		</c:if>
                   <li class="clear"></li>
               </ul>
           </div>
</div>
</body>
</html>