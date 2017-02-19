<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>登录界面</title>
    <!-- basic styles -->

    <link href="../static/frame/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="../static/frame/Font/css/font-awesome.min.css" />

    <!--[if IE 7]>
    <link rel="stylesheet" href="frame/Font/css/font-awesome-ie7.min.css" />
    <![endif]-->

    <!-- page specific plugin styles -->


    <!-- ace styles -->

    <link rel="stylesheet" href="../static/css/ace.min.css" />
    <link rel="stylesheet" href="../static/css/ace-rtl.min.css" />

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="/static/css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="/static/js/html5shiv.js"></script>
    <script src="/static/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="login-layout">
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">

                <div class="login-container">
                    <div class="space-6"></div>
                    <div class="position-relative" style="margin-top:35%">
                        <div id="login-box" class="login-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header blue lighter bigger">
                                        <i class="icon-coffee green"></i>
                                        请输入你的信息
                                    </h4>
                                    <div class="space-6"></div>
									<div id="errorMessage" style="color:red">&nbsp;</div>
                                    <form>
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<c:set var="user" value=""></c:set>
														<c:if test="${cookie.username.value != null}" >
														
														</c:if>
															<input type="text" class="form-control" id="userName" placeholder="用户名" value='${user}'></input>
															<i class="icon-user"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" id="password" placeholder="密码" />
															<i class="icon-lock"></i>
														</span>
                                            </label>
						

                                            <label>
											<span style="display:inline-block">
											<input type="text" class="form-control" style="width:140px" placeholder="验证码" id="verifyCode" /></span>
<span style="display:inline-block;">
<img style="vertical-align
:down" src="/Blog/VerifyCode" id="verifyimg"/>
</span>	
<span>
<a href="#" id="change">换一张</a>	
</span>	
													
                                            </label>

                                            <div class="space"></div>

                                            <div class="clearfix">

                                                <button type="button" style="width:100%" class="btn btn btn-danger" id="submitButton">
                                                    <i class="icon-key"></i>
                                                    登录
                                                </button>
                                            </div>
											
                                            <div class="space-4"></div>
                                        </fieldset>
                                    </form>

 							<div class="space-6"></div>
 							<div class="space-6"></div>
                                </div><!-- /widget-main -->

                                <div class="toolbar clearfix" style="background:#394557">
                                    <div>
                                        <a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
                                            <i class="icon-arrow-left"></i>
                                            <span style="color:#fff;font-size:20px">忘记密码</span>
                                        </a>
                                    </div>

                                    <div>
                                        <a href="#" onclick="show_box('signup-box'); return false;" class="user-signup-link">
                                            <span style="color:#fff;font-size:20px">注册</span>
                                            <i class="icon-arrow-right"></i>
                                        </a>
                                    </div>
                                </div>
                            </div><!-- /widget-body -->
                        </div><!-- /login-box -->

                        <div id="forgot-box" class="forgot-box widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header red lighter bigger">
                                        <i class="icon-key"></i>
                                        重置密码
                                    </h4>

                                    <div class="space-6"></div>
                                    <p>
                                        	输入你的邮箱并验证
                                    </p>
									<div id="findErrorMessage" style="color:red">&nbsp;</div>
                                    <form>
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" placeholder="邮箱" id="findEmail"/>
															<i class="icon-envelope"></i>
														</span>
														
                                            </label>
                                            <label class="block clearfix">
                                            														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="用户名" id="findUser"/>
															<i class="icon-user"></i>
														</span>
                                            </label>
											<div class="space-24"></div>
                                            <div class="clearfix">
                                                <button type="button" class="width-35 pull-right btn btn-sm btn-danger" id="findButton">
                                                    <i class="icon-lightbulb"></i>
                                                    发送
                                                </button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div><!-- /widget-main -->

                                <div class="toolbar center" style="background:#394557">
                                    <a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
                        <span style="color:#fff;font-size:20px">返回登录界面</span>
                                        <i class="icon-arrow-right"></i>
                                    </a>
                                </div>
                            </div><!-- /widget-body -->
                        </div><!-- /forgot-box -->

                        <div id="signup-box" class="signup-box widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header green lighter bigger">
                                        <i class="icon-group blue"></i>
                                        注册
                                    </h4>

                                    <div class="space-6"></div>
                                    <p> 填写以下信息 </p>
									<div id="signerrorMessage" style="color:red">&nbsp;</div>
                                    <form>
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" placeholder="邮箱" id="signemail"/>
															<i class="icon-envelope"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="用户名" id="signname"/>
															<i class="icon-user"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="密码" id="signpassword"/>
															<i class="icon-lock"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="再次输入密码" id="repassword" />
															<i class="icon-retweet"></i>
														</span>
                                            </label>

                                            <label class="block">
                                                <input type="checkbox" class="ace" id="checkbox"/>
														<span class="lbl">
															我同意
															<a href="#">所有协议</a>
														</span>
                                            </label>

                                            <div class="space-24"></div>

                                            <div class="clearfix">
                                                <button type="reset" class="width-30 pull-left btn btn-sm">
                                                    <i class="icon-refresh"></i>
                                                    重置
                                                </button>

                                                <button type="button" class="width-65 pull-right btn btn-sm btn-success" id="signbutton">
                                                    注册
                                                    <i class="icon-arrow-right icon-on-right"></i>
                                                </button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div>

                                <div class="toolbar" style="text-align:center;width:100%;background:#394557">
                                    <a href="#" onclick="show_box('login-box'); return false;">
                                        <i class="icon-arrow-left"></i>
                                        <span style="color:#fff;font-size:20px">返回登录界面</span>
                                    </a>
                                </div>
                            </div><!-- /widget-body -->
                        </div><!-- /signup-box -->
                    </div><!-- /position-relativze -->
                </div>
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div>
</div><!-- /.main-container -->

<!-- basic scripts -->


<!--[if !IE]> -->

<script type="text/javascript">
    window.jQuery || document.write("<script src='../static/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='../static/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>

<!-- inline scripts related to this page -->

<script type="text/javascript">
    function show_box(id) {
        jQuery('.widget-box.visible').removeClass('visible');
        jQuery('#'+id).addClass('visible');
    }
</script>
<script>
    	jQuery("#change").click(function(){
    		jQuery("#verifyimg").attr("src","/Blog/VerifyCode?time="+new Date().getTime());
    	})
</script>
<script>
		$("#submitButton").click(function(){
			var userValue=$("#userName").val();
			var wordValue=$("#password").val();
			var codeValue=$("#verifyCode").val();
			console.log(userValue+"--"+wordValue);
			if(userName==""){
				$("#errorMessage").html("用户名不得为空");
			}
			else if(wordValue==""){
				$("#errorMessage").html("密码不得为空");
			}
			else if(codeValue==""){
				$("#errorMessage").html("验证码不得为空");
			}
			else if(userValue.replace(/[ ]/g, '')!=userValue){
				$("#errorMessage").html("用户名不能包含空格");
			}
			else{
				$("#errorMessage").html("请稍等....");
	  			$.ajax({
	  				url:"/Blog/Login.do",
	  				async:true,
	  				type: "POST",
	          		data:{
	          			'userName':userValue,
	          			'password':wordValue,
	          			'verifyCode':codeValue
	          		},
	          		success:function(data){
	          			if(data.indexOf("/")!=-1){
	          				location.href=data;
	          			}
	          			else{
						$("#errorMessage").html(data);
						$("#verifyimg").attr("src","/Blog/VerifyCode?time="+new Date().getTime());
						}
						}
	  				});
			}
			});
</script>
<script>
		$("#signbutton").click(function(){
			var userValue=$("#signname").val();
			var wordValue=$("#signpassword").val();
			var emailValue=$("#signemail").val();
			var rewordValue=$("#repassword").val();
			var check=$("#checkbox");
			var strcheck=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
			if(emailValue==""){
				$("#signerrorMessage").html("邮箱不得为空");
			}
			else if(!strcheck.test(emailValue)){
				$("#signerrorMessage").html("邮箱格式不正确");
			}
			else if(userValue==""){
				$("#signerrorMessage").html("用户名不得为空");
			}
			else if(wordValue==""){
				$("#signerrorMessage").html("密码不得为空");
			}
			else if(rewordValue==""){
				$("#signerrorMessage").html("密码不得为空");
			}
			else if(userValue.replace(/[ ]/g, '')!=userValue){
				$("#signerrorMessage").html("用户名不能包含空格");
			}
			else if(rewordValue.replace(/[ ]/g, '')!=wordValue){
				$("#signerrorMessage").html("密码不能包含空格");
			}
			else if(!check.checked=="checked"){
				$("#signerrorMessage").html("协议不能不勾");
			}
			else if(wordValue!=rewordValue){
				$("#signerrorMessage").html("密码不一致");
			}
			else{
				$("#signerrorMessage").html("请稍等....");
	  			$.ajax({
	  				url:"/Blog/Sign.do",
	  				async:true,
	  				type: "POST",
	          		data:{
	          			'userName':userValue,
	          			'password':wordValue,
	          			'email':emailValue
	          		},
	          		success:function(data){
	          			$("#signerrorMessage").html(data);
					}
	  				});
			}
			});
</script>
<script>
		$("#signname").blur(check());
		$("#signemail").blur(check());
		function check(){
			var userValue=$("#signname").val();
			var emailValue=$("#signemail").val();
	  			$.ajax({
	  				url:"/Blog/ConfirmRepeat.do",
	  				async:true,
	  				type: "POST",
	          		data:{
	          			'userName':userValue,
	          			'email':emailValue
	          		},
	          		success:function(data){
	          			if(data.indexOf("重复")!=-1){
	          				$("#signbutton").attr({"disabled":"disabled"})
							$("#signerrorMessage").html(data);
	          			}
	          			else{
	          				console.log("haha");
	          				$("#signbutton").removeAttr("disabled");
							}
						}
	  				});
			}
</script>
<script>
$("#findButton").click(function(){
	var findEmail = $("#findEmail").val();
	var findUser = $("#findUser").val();
	var strcheck=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	var content ="尊敬的用户"+findUser+"您好,您已经申请找回用户密码，并已经成功受理，打开链接完成修改密码吧。哈哈似乎离成功更近了呢."
	if(findEmail==""){
		$("#findErrorMessage").html("Email不能为空!");
	}
	else if(findUser==""){
		$("#findErrorMessage").html("用户名不能为空!");
	}
	else if(!strcheck.test(findEmail)){
		$("#findErrorMessage").html("邮箱格式不正确");
	}
	else{
		$.ajax({
	  				url:"/Blog/Email.do",
	  				async:true,
	  				type: "POST",
	          		data:{
	          			'email':findEmail,
	          			'userName':findUser,
	          			'content':content
	          		},
	          		success:function(data){
						$("#findErrorMessage").html(data);
						}
	  				});
	}
})
</script>
</body>
</html>
