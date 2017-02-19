<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set  var="visit"  value="123456789"  scope="session"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="./static/css/message.css" rel="stylesheet">
    	<script src="./static/js/jquery-2.0.3.min.js"></script>
    <link rel="stylesheet" href="./static/frame/Font/css/font-awesome.min.css">
	<link rel="stylesheet" href="./static/frame/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="./static/frame/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="./static/frame/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="./static/frame/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="./static/frame/kindeditor/plugins/code/prettify.js"></script>
</head>
<body>
<!--导航栏-->
<div class="navbar">
    <div class="navbar-inner">
        <ul>
            <li><a href="/Blog/index">首页</a></li>
            <li><a href="/Blog/diary">日志</a></li>
            <li><a href="/Blog/photograph">相册</a></li>
            <li class="active"><a href="#">留言板</a></li>
            <li><a href="#">个人档</a></li>
        </ul>
            <div class="login">
            <c:if test="${sessionScope.user eq null}"><a href="/Blog/view/login.jsp" class="alogin">登录</a></c:if>
            <c:if test="${sessionScope.user ne null}"><a href="/Blog/exit" class="alogin">退出</a><a><img src="${sessionScope.user.touxiang}"/></a></c:if>
            </div>
    </div>
</div>
<div class="container">
    <div class="header">
        <p><h3>&nbsp;留言板</h3></p>
        <hr/>
    </div>
       <div>
           <div >
               <div class="content-header">主人寄语</div>
               <div class="myword">未登录是不能留言的哦!</div>
           </div>
           <div class="welcome">
               <h3>大家的留言</h3>
               <hr/>
           </div>
           <div class="visitword">
               <ul>
               <c:forEach var="visit" items="${divide.wordList}">
                   <li id="${visit.ID}">
                   <div class="visit">
                       		<div class="line_left"><img src="${visit.user.touxiang}"/></div>
                       		<div class="line_right">
                           <div class="line"><span class="user">${visit.user.userName}</span>&nbsp;<fmt:formatDate value="${visit.time}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
                           <c:if test="${visit.secret}">
                           <c:set var="admin" value="admin"></c:set>
                           <c:choose>
                           <c:when test="${(sessionScope.user.userName eq 'admin') or (sessionScope.user.userName eq visit.user.userName)}">
                            <p class="text">${visit.word}</p>
                           </c:when>
                           	<c:otherwise>
                           	<p class="secret">此消息为私密消息</p>
                           	</c:otherwise>
                           	</c:choose>
                           </c:if>
                           <c:if test="${!visit.secret}">
                              <p class="text">${visit.word}</p>
                           </c:if>
                           <a class="areply">回复</a>
                           <c:if test="${(visit.user.userName eq sessionScope.user.userName) or (sessionScope.user.userName eq 'admin')}">
                           <a class="areply" href="/Blog/visitRemove?ID=${visit.ID}">删除评论</a>
                       		</c:if>
                       </div>
                       </div>
                       <c:if test="${visit.list != null}">
                       <c:forEach var="reply" items="${visit.list}">
                           <div class="reply">
                           <div class="line_left"><img src="${reply.user.touxiang}"/></div>
                           <div class="line_right">
                               <div class="line"><span class="user">${reply.user.userName}</span>回复${reply.to_who}&nbsp;<fmt:formatDate value="${reply.time}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
                           <c:if test="${reply.secret}">
                           <c:set var="admin" value="admin"></c:set>
                           <c:choose>
                           <c:when test="${(sessionScope.user.userName eq admin) or (sessionScope.user.userName eq visit.user.userName) or (sessionScope.user.userName eq reply.user.userName)}">
                            <p class="text">${reply.word}</p>
                           </c:when>
                           	<c:otherwise>
                           	<p class="secret">此消息为私密消息</p>
                           	</c:otherwise>
                           	</c:choose>
                           </c:if>
                           <c:if test="${!reply.secret}">
                              <p class="text">${reply.word}</p>
                           </c:if>
                           <a class="areply">回复</a>
                           <c:if test="${(reply.user.userName eq sessionScope.user.userName) or (sessionScope.user.userName eq 'admin')}">
                           <a class="areply" href="/Blog/replyRemove?ID=${reply.ID}">删除评论</a>
                       		</c:if>
                           </div>
                       </div>
                       </c:forEach>
                       </c:if>
                   </li>
               </c:forEach>
               </ul>
               </div>
               <div class="content">
               <ul class="pagination">
               <c:choose>
               		<c:when test="${divide.totalRecored<=10}">
               			<c:set var="begin" value="1"></c:set>
               			<c:set var="end" value="${divide.totalRecored}"></c:set>
               		</c:when>
               		<c:otherwise>
               			<c:set var="begin" value="${divide.wordCode-4}"></c:set>
               			<c:set var="end" value="${divide.wordCode+5}"></c:set>
	               <c:if test="${begin<1}">
	    				<c:set var="begin" value="1"/>
	    				<c:set var="end" value="10"/>
	               </c:if>
	               <c:if test="${end>divide.totalRecored}">
	    				<c:set var="begin" value="${divide.totalRecored-9}"/>
	    				<c:set var="end" value="${divide.totalRecored}"/>
	               </c:if>
               </c:otherwise>
             </c:choose>
              		<c:if test="${divide.wordCode==1}">
                    	<li><a href="#" >&laquo;</a></li>              		
               		</c:if>
                   <c:if test="${divide.wordCode!=1}">
                    	<li><a href="/Blog/message?wordCode=${divide.wordCode-1}" >&laquo;</a></li>
               		</c:if>
               		
		        		<c:forEach begin="${begin}" end="${end}" var="i">
		        		<c:choose>
		        			<c:when test="${i eq divide.wordCode}">
		        				 <li><a href="#" class="nowpage">${i}</a></li>
		        			</c:when>
		        			<c:otherwise>
		        			    	<li><a href="/Blog/message?wordCode=${i}">${i}</a></li>
		        			</c:otherwise>
		        		</c:choose>
		        		</c:forEach>
        		<c:if test="${divide.wordCode==divide.totalRecored}">
        			<li><a href="#">&raquo;</a></li>
        		</c:if>
        		<c:if test="${divide.wordCode!=divide.totalRecored}">
           			<li><a href="/Blog/message?wordCode=${divide.wordCode+1}">&raquo;</a></li>     				
        		</c:if>
               </ul>
           </div>
			<div class="form">
			<form name="example" method="post" action="/Blog/visit.do">
				<textarea name="word" id="content" cols="100" rows="8" style="width:700px;height:200px;"></textarea>
				<br/>
				<input type="submit" class="button" value="提交内容" /> (提交快捷键: Ctrl + Enter)
				<input name="visitCheckbox" type="checkbox"/><span class="check">私密回复</span>
			</form>
			</div>
           </div>
       </div>
		<c:if test="${sessionScope.user.userName eq null}">
			<script>$(".button").attr("disabled","disabled");</script>
		</c:if>
		<c:if test="${sessionScope.user.userName ne null}">
       		<script src="./static/js/message.js"></script>
		</c:if>
</body>
<script>
var editor2 = KindEditor.create('#content',{
	cssPath : './static/frame/kindeditor/plugins/code/prettify.css',
	uploadJson : './static/frame/kindeditor/jsp/upload_json.jsp',
	fileManagerJson : './static/frame/kindeditor/jsp/file_manager_json.jsp',
	allowFileManager : true,
	afterBlur: function(){this.sync();},
	afterCreate : function() {
		var self = this;
		KindEditor.ctrl(document, 13, function() {
			self.sync();
			document.forms['example'].submit();
		});
		KindEditor.ctrl(self.edit.doc, 13, function() {
			self.sync();
			document.forms['example'].submit();
		});
	}
})
</script>
</html>