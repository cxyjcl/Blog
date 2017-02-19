<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="../../static/css/changePassword.css" rel="stylesheet">
    <link href="../static/frame/Font/css/font-awesome.min.css">
    <script src="../../static/js/jquery-2.0.3.min.js"></script>
    <script src="http://static.geetest.com/static/tools/gt.js"></script>
</head>
<body>
<div class="navbar">
    <div class="navbar-inner">
        <ul>
            <li><a href="./index.html">首页</a></li>
            <li><a href="#">日志</a></li>
            <li><a href="#">相册</a></li>
            <li><a href="#">留言板</a></li>
            <li><a href="#">个人档</a></li>
        </ul>
        <div class="login">
            <a href="#">登录</a>
        </div>
    </div>
</div>
<div class="maincontent">
    <div class="header">
        <p>
        <h3>&nbsp;找回密码</h3></p>
        <hr/>
    </div>
    <div class="container">
        <form class="form">
            <ul>
            	<li class="classify">
            	   <div id="errorMessage" style="color:red">&nbsp;</div>
            	</li>
                <li class="classify">
                    <blockquote>邮箱:</blockquote>
                    <input type="text" class="form-control" id="email" disabled="true" placeholder="邮箱" value="${param.email}"/>
                </li>
                <li class="classify">
                    <blockquote>密码:</blockquote>
                    <input type="password" id="password" placeholder="密码"/>
                </li>
                <li class="classify">
                    <blockquote>重新输入密码:</blockquote>
                    <input type="password" id="repassword" placeholder="密码"/>
                </li>
                <li  class="classify">
                    <blockquote>验证码:</blockquote>
                    <div id="embed-captcha"></div>
   		 			<p id="wait" class="show">正在加载验证码......</p>
    				<p id="notice" class="hide">请先拖动验证码到相应位置</p>
                </li>
                <li class="classify">
                    <button type="button" class="button" id="changeButton">修改密码</button>
                </li>
            </ul>
        </form>
    </div>
</div>
</body>
<script>

    var handlerEmbed = function (captchaObj) {

        $("#changeButton").click(function (e) {
            var validate = captchaObj.getValidate();
            var email = $("#email").val();
			var password = $("#password").val();
			var repassword = $("#repassword").val();
			var key = "${param.apt}";
 			if(email==""){
				$("#errorMessage").html("Email不能为空!");
			}
			else if(password==""){
				$("#errorMessage").html("密码不能为空!");
			}
			else if(repassword==""){
				$("#errorMessage").html("密码不能为空!");
			}
			else if(repassword.replace(/[ ]/g, '')!=repassword){
				$("#errorMessage").html("密码不能包含空格");
			}
			else if(password.replace(/[ ]/g, '')!=password){
				$("#errorMessage").html("密码不能包含空格");
			}
			else if(password!=repassword){
				$("#errorMessage").html("密码不一致");
			}
			else if (!validate) {
				$("#errorMessage").html("请先拖动验证码到相应位置");
                e.preventDefault();
            }
			else{
				$.ajax({
			  				url:"/Blog/Change.do",
			  				async:true,
			  				type: "POST",
			          		data:{
			          			'email':email,
			          			'password':password,
			          			'key':key
			          		},
			          		success:function(data){
								$("#errorMessage").html(data);
								}
			  				});
			}
        });

        // 将验证码加到id为captcha的元素里
        captchaObj.appendTo("#embed-captcha");

        captchaObj.onReady(function () {
            $("#wait")[0].className = "hide";
        });

        // 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
    };
     $.ajax({
        // 获取id，challenge，success（是否启用failback）
        url: "/Blog/Slider",
        type: "get",
        dataType: "json",
        success: function (data) {

            // 使用initGeetest接口
            // 参数1：配置参数
            // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它做appendTo之类的事件
            initGeetest({
                gt: data.gt,
                challenge: data.challenge,
                product: "embed", // 产品形式，包括：float，embed，popup。注意只对PC版验证码有效
                offline: !data.success // 表示用户后台检测极验服务器是否宕机，一般不需要关注
            }, handlerEmbed);
        }
    }); 

</script>
</html>
</html>
