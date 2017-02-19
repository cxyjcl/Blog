<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<c:set  var="visit"  value="123456789"  scope="session"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link href="static/css/main.css" rel="stylesheet">
    <link rel="stylesheet" href="static/frame/Font/css/font-awesome.min.css">
        	<script src="./static/js/jquery-2.0.3.min.js"></script>
  </head>
  
  <body>
      <!--导航栏-->
    <div class="navbar">
        <div class="navbar-inner">
            <ul>
                <li class="active"><a href="#">首页</a></li>
                <li ><a href="/Blog/diary">日志</a></li>
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
    <!--主页-->
    <div class="maincontent">
        <!--左侧-->
        <div class="both">
            <div class="imgcontent">
                <img src="static/img/author.jpg"/>
            </div>
            <div class="textcontent">
                <p class="bigtext">我有故事谁有酒</p>
                <p class="smalltext">欢迎大家的到来。</p>
            </div>
            <div class="userinfo">
                <p class="visitcount">访客量:<em>${count}</em></p>
                <div class="goto">
                    <a href="/Blog/message">留言板</a>
                    <a href="/Blog/photograph">相册</a>
                    <a href="#">个人档</a>
                </div>
            </div>
            <div class="topvisit">&nbsp;访客评论</div>
            <div class="visitword">
                <ul>
                	<c:forEach var="visit" items="${visit}">
                		<div class="visit">
                			<div class="line_left"><img src="${visit.user.touxiang}"/></div>
                       		<div class="line_right">
                           <div class="line"><span class="user">${visit.user.userName}</span><fmt:formatDate value="${visit.time}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
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
                		</div>
                		<div class="clear"></div>
                		</div>
                	</c:forEach>
                </ul>
            </div>
        </div>
        <!--右侧-->
        <div class="both">
			 <c:forEach var="page" items="${page}">
            <div class="content">
                    <div class="content-header"><input type='text' value="${page.title}" readonly="true"/></div>
                    <div class="page">${page.content}</div>
                    <div class="content-footer">
                        <span><fmt:formatDate value="${page.time}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                        <a>围观:<em>${page.click}</em></a>
                        <a href="/Blog/Content?title=${page.title}&time=${page.time}">阅读全文</a>
                    </div>
                    <br/>
                    <br/>
            </div>
           		</c:forEach>
        </div>
    </div>
    <script>
    $(function() {
    $(".page").each(function() {
        var s = $(this).html();
        $(this).html(cutstr(s, 900));
    });
});
function cutstr(str, len) {
    var str_length = 0;
    var str_len = 0;
    str_cut = new String();
    str_len = str.length;
    for (var i = 0; i < str_len; i++) {
        a = str.charAt(i);
        str_length++;
        if (escape(a).length > 4) {
            //中文字符的长度经编码之后大于4
            str_length++;
        }
        str_cut = str_cut.concat(a);
        if (str_length >= len) {
            str_cut = str_cut.concat("...");
            return str_cut;
        }
    }
    //如果给定字符串小于指定长度，则返回源字符串；
    if (str_length < len) {
        return str;
    }
} 
    </script>
  </body>
</html>
