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
    <title>日志</title>
    <link href="./static/css/diary.css" rel="stylesheet">
    <link rel="stylesheet" href="./static/frame/Font/css/font-awesome.min.css">
    <style type="text/css">
    </style>
    <script type="text/javascript" src="./static/js/jquery-2.0.3.min.js"></script>
</head>
<body>
<!--导航栏-->
<div class="navbar">
    <div class="navbar-inner">
        <ul>
            <li><a href="/Blog/index">首页</a></li>
            <li class="active"><a href="#">日志</a></li>
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
<!--日志栏-->
<div class="container">
    <div class="header">
        <p><h3>&nbsp;日志</h3></p>
        <hr/>
    </div>
        <!--左侧日志-->
       <div class="inline">
      			<c:forEach var="pagebean" items="${page.pageList}">
               <div class="content">
                   <a class="content-header character" href="/Blog/Content?title=${pagebean.title}&time=${pagebean.time}">${pagebean.title}</a>
                   <div class="content-footer">
                       <span><fmt:formatDate value="${pagebean.time}" pattern="yyyy-MM-dd"/></span>
                       <span>围观:<em>${pagebean.click}</em></a>
                   </div>
               </div>
               </c:forEach>
           <div class="content">
               <ul class="pagination">
               <c:choose>
               		<c:when test="${page.totalPages<=10}">
               			<c:set var="begin" value="1"></c:set>
               			<c:set var="end" value="${page.totalPages}"></c:set>
               		</c:when>
               		<c:otherwise>
               			<c:set var="begin" value="${page.pageCode-4}"></c:set>
               			<c:set var="end" value="${page.pageCode+5}"></c:set>
	               <c:if test="${begin<1}">
	    				<c:set var="begin" value="1"/>
	    				<c:set var="end" value="10"/>
	               </c:if>
	               <c:if test="${end>page.totalPages}">
	    				<c:set var="begin" value="${page.totalPages-9}"/>
	    				<c:set var="end" value="${page.totalPages}"/>
	               </c:if>
               </c:otherwise>
             </c:choose>
              		<c:if test="${page.pageCode==1}">
                    	<li><a href="#" >&laquo;</a></li>              		
               		</c:if>
                   <c:if test="${page.pageCode!=1}">
                   <c:choose>
                         <c:when test="${param.property!=null}">
                    		<li><a href="/Blog/diary?property=${param.property}&pageCode=${page.pageCode-1}" >&laquo;</a></li>
                    	</c:when>
                    	<c:when test="${param.find!=null}">
                    		<li><a href="/Blog/diary?find=${param.find}&pageCode=${page.pageCode-1}" >&laquo;</a></li>
                    	</c:when>
                    	<c:otherwise>
                    		<li><a href="/Blog/diary?pageCode=${page.pageCode-1}" >&laquo;</a></li>
                    	</c:otherwise>
                    	</c:choose>           		
               		</c:if>
               		
		        		<c:forEach begin="${begin}" end="${end}" var="i">
		        		<c:choose>
		        			<c:when test="${i eq page.pageCode}">
		        				 <li><a href="#" class="nowpage">${i}</a></li>
		        			</c:when>
		        			<c:otherwise>
		        			<c:choose>
		        				<c:when test="${param.property!=null}">
		        			    	<li><a href="/Blog/diary?property=${param.property}&pageCode=${i}">${i}</a></li>
		        			    </c:when>
		        			    <c:when test="${param.find!=null}">
		        			    	<li><a href="/Blog/diary?find=${param.find}&pageCode=${i}">${i}</a></li>
		        			    </c:when>
		        			    <c:otherwise>
		        			    	<li><a href="/Blog/diary?pageCode=${i}">${i}</a></li>
		        			    </c:otherwise>
		        			  </c:choose>
		        			</c:otherwise>
		        		</c:choose>
		        		</c:forEach>
        		<c:if test="${page.pageCode==page.totalPages}">
        			<li><a href="#">&raquo;</a></li>
        		</c:if>
        		<c:if test="${page.pageCode!=page.totalPages}">
        			<c:choose>
        				<c:when test="${param.property!=null}">
        					<li><a href="/Blog/diary?property=${param.property}&pageCode=${page.pageCode+1}">&raquo;</a></li>
        				</c:when>
        				<c:when test="${param.find!=null}">
        					<li><a href="/Blog/diary?find=${param.find}&pageCode=${page.pageCode+1}">&raquo;</a></li>
        				</c:when>
        				<c:otherwise>
           					<li><a href="/Blog/diary?pageCode=${page.pageCode+1}">&raquo;</a></li>     				
        				</c:otherwise>
        			</c:choose>
        		</c:if>
                   <li class="clear"></li>
               </ul>
           </div>
       </div>
        <!--右侧总概-->
        <div class="inline" id="rightContent">
            <div class="classify">日志分类</div>
        </div>
         <div class="inline">
          <hr/>
            <div class="classify">搜索日志</div>
            <div class="classify"><input type="text" id="findvalue"/><a href="#" style="position: relative;right: 20px" id="search"><i class="icon-search"></i></a></div>
            <div class="space"></div>
        </div>
</div>
</body>
<script>
		$.ajax({
	  				url:"/Blog/PageInfo.do",
	  				async:true,
	  				type: "POST",
	          		success:function(data){
	          			var json = JSON.parse(data);
						console.log(json);
						$("#rightContent").append("<div class='classify'>全部日志<em>"+json.total+"</em></div>");
						$.each(json.distinct,function(n,value) {  
							$("#rightContent").append("<div class='classify'><a href=/Blog/diary?property="+value.property+">"+value.property+"<em>"+value.count+"</em></a></div>");
						})
						}
	  				});
	  			
</script>
<script>
	  	$("#search").click(function(){
	  		location.href="/Blog/diary?find="+$("#findvalue").val();
	  	})
</script>
</html>
