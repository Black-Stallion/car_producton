<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common_js.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="copyright" content="Copyright 2016" />
<meta name="Author" content="金路信息技术网络有限责任公司" />
<meta name="keywords" content="汽车管理系统--车辆信息管理,车辆异动,出车申请,维保申请,运行情况管理,安全管理" />
<meta name="description" content="汽车管理系统登录页面/系统登陆页面" />
<title>机动车管理信息系统登录页面</title>
<link rel="stylesheet" type="text/css" href="css/login/style.css" />
<link href="css/login.css" rel="stylesheet" type="text/css" />
<link href="css/demo.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header">
  <h1 class="headerLogo"><a title=""><img alt="logo" src="image/logo.gif"></a></h1>
</div>

<div class="banner">
<div class="login-aside">
  <div id="o-box-up"></div>
  <div id="o-box-down">
	 <form name="login" action="#" method="post">
				<fieldset>
					<!--USERNAME -->
						<div class="fm-item">
							<label for="logonId" class="form-label">系统登陆</label>
							<input name="name" id="username" placeholder="用户名" type="text" class="i-text" maxLength="24" />
						</div>
						<div id="username_span"style="display:none;padding-bottom:7px;">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="userspan"></span>
						</div>
					
					<!-- PASSWORD -->
						<div class="fm-item">
						<label for="logonId" class="form-label">登陆密码</label>
							<input name="password" id="password" type="password" placeholder="密码" class="i-text" maxLength="24" />
						</div>
						
						<div id="password_span"style="display:none;margin:0 0 0 0;padding:0 0 0 0;">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="passwordspan"></span>
						</div>
	
						<div style="margin-bottom:12px">
							<div id="randiv" style="display:none;margin-left:98px;">
							</div>
							<div style="margin-left:98px;">
								<span id="errorspan"></span>
							</div>
						</div>
					
					<!-- LOGIN -->
					<!-- 
						<div class="enter">
							<input class="button hide" name="submit" type="submit" value="登录" />
						</div> 
					-->
					<div class="fm-item">
						<label for="logonId" class="form-label"></label>
						<a href="#"  id="login"  class="btn-login"><img src="image/login-btn.png"></a>
					</div>
					
				</fieldset>
			</form>
  </div>

</div>
	<div class="bd">
		<ul>
			<li style="background:url(image/theme-pic1.jpg) #CCE1F3 center 0 no-repeat;"></li>
		</ul>
	</div>
</div>
<script type="text/javascript" src="js/login/placeholder.js"></script>
<script type="text/javascript">
document.onkeydown=function(e){
    if(!e) e=window.event;
   if((e.keyCode || e.which) ==13){
			var uname = $("#username");
			var pwd = $("#password");
			var display = $("#randiv").css('display');
			var rcode = $("#randomcode");

			if (display == 'none') {
				if ($.trim(uname.val()) == "") {
					$('#username_span').css('display','block');
					$("#passwordspan").html("");
					$("#userspan")
							.html(
									"<font color='red'>用户名不能为空！</font>");
					uname.focus();
				} else if ($.trim(pwd.val()) == "") {
					$('#username_span').css('display','none');
					$('#password_span').css('display','block');
					$("#userspan").html("");
					$("#passwordspan").html(
							"<font color='red'>密码不能为空！</font>");
					pwd.focus();
				} else {
					$('#password_span').css('display','none');
					$("#userspan").html("");
					$("#passwordspan").html("");
					$
							.ajax({
								url : '${baseurl}ajaxLogin',// 跳转到 action  
								data : {
									username : uname.val(),
									password : pwd.val(),
								},
								type : 'post',
								cache : false,
								dataType : 'json',
								success : function(data) {
									if (data.msg == 'account_error') {
								console.log("account_erroe.");
										$("#errorspan")
												.html(
														"<font color='red'> 用户不存在！</font>");
										rcode_flag = 1;
									} else if (data.msg == 'password_error') {
										$("#errorspan")
												.html(
														"<font color='red'> 密码错误！</font>");
										rcode_flag = 1;
									} else if (data.msg == 'authentication_error') {
										$("#errorspan")
												.html(
														"<font color='red'> 您没有授权！</font>");
										rcode_flag = 1;
									} else {
										location.href = "${baseurl}home";
									}
								},
								error : function() {
									// view("异常！");  
									alert("异常！");
								}
							});
				}
			} else {
				$("#errorspan").html("");
				if ($.trim(uname.val()) == "") {
					$("#passwordspan").html("");
					$("#userspan")
							.html(
									"<font color='red'>用户名不能为空！</font>");
					uname.focus();
				} else if ($.trim(pwd.val()) == "") {
					$("#userspan").html("");
					$("#passwordspan").html(
							"<font color='red'>密码不能为空！</font>");
					pwd.focus();
				} else if ($.trim(rcode.val()) == "") {
					$("#userspan").html("");
					$("#randomcode_span")
							.html(
									"<font color='red'>验证码不能为空！</font>");
					rcode.focus();
				} else {
					$("#userspan").html("");
					$("#passwordspan").html("");
					$("#randomcode_span").html("");
					$
							.ajax({
								url : '${baseurl}ajaxLogin',// 跳转到 action  
								data : {
									username : uname.val(),
									password : pwd.val(),
									randomcode : rcode.val(),
								},
								type : 'post',
								cache : false,
								dataType : 'json',
								success : function(data) {
									if (data.msg == 'account_error') {
										$("#errorspan")
												.html(
														"<font color='red'> 用户不存在！</font>");
										rcode_flag = true;
									} else if (data.msg == 'password_error') {
										$("#errorspan")
												.html(
														"<font color='red'> 密码错误！</font>");
										rcode_flag = true;
									} else if (data.msg == 'randomcode_error') {
										$("#errorspan")
												.html(
														"<font color='red'> 验证码错误！</font>");
										rcode_flag = true;
									} else if (data.msg == 'authentication_error') {
										$("#errorspan")
												.html(
														"<font color='red'> 您没有授权！</font>");
										rcode_flag = true;
									} else {
										location.href = "${baseurl}home";
									}
								},
								error : function() {
									// view("异常！");  
									alert("异常！");
								}
							});
				}
			}
		
	 //刷新验证码
	 //实现思路，重新给图片的src赋值，后边加时间，防止缓存
   }
	   
}
$("#login")
.click(
		function() {
			var uname = $("#username");
			var pwd = $("#password");
			var display = $("#randiv").css('display');
			var rcode = $("#randomcode");

			if (display == 'none') {
				if ($.trim(uname.val()) == "") {
					$('#username_span').css('display','block');
					$("#passwordspan").html("");
					$("#userspan")
							.html(
									"<font color='red'>用户名不能为空！</font>");
					uname.focus();
				} else if ($.trim(pwd.val()) == "") {
					$('#username_span').css('display','none');
					$('#password_span').css('display','block');
					$("#userspan").html("");
					$("#passwordspan").html(
							"<font color='red'>密码不能为空！</font>");
					pwd.focus();
				} else {
					$('#password_span').css('display','none');
					$("#userspan").html("");
					$("#passwordspan").html("");
					$
							.ajax({
								url : '${baseurl}ajaxLogin',// 跳转到 action  
								data : {
									username : uname.val(),
									password : pwd.val(),
								},
								type : 'post',
								cache : false,
								dataType : 'json',
								success : function(data) {
									if (data.msg == 'account_error') {
								console.log("account_erroe.");
										$("#errorspan")
												.html("<font color='red'> 该用户不存在！</font>");
										rcode_flag = 1;
									} else if (data.msg == 'password_error') {
										$("#errorspan")
												.html(
														"<font color='red'> 密码错误！</font>");
										rcode_flag = 1;
									} else if (data.msg == 'authentication_error') {
										$("#errorspan")
												.html(
														"<font color='red'> 您没有授权！</font>");
										rcode_flag = 1;
									} else {
										location.href = "${baseurl}home";
									}
								},
								error : function() {
									// view("异常！");  
									alert("异常！");
								}
							});
				}
			} else {
				$("#errorspan").html("");
				if ($.trim(uname.val()) == "") {
					$("#passwordspan").html("");
					$("#userspan")
							.html(
									"<font color='red'>用户名不能为空！</font>");
					uname.focus();
				} else if ($.trim(pwd.val()) == "") {
					$("#userspan").html("");
					$("#passwordspan").html(
							"<font color='red'>密码不能为空！</font>");
					pwd.focus();
				} else {
					$("#userspan").html("");
					$("#passwordspan").html("");
					$("#randomcode_span").html("");
					$
							.ajax({
								url : '${baseurl}ajaxLogin',// 跳转到 action  
								data : {
									username : uname.val(),
									password : pwd.val(),
									randomcode : rcode.val(),
								},
								type : 'post',
								cache : false,
								dataType : 'json',
								success : function(data) {
									if (data.msg == 'account_error') {
										$("#errorspan")
												.html(
														"<font color='red'> 用户不存在！</font>");
										rcode_flag = true;
									} else if (data.msg == 'password_error') {
										$("#errorspan")
												.html(
														"<font color='red'> 密码错误！</font>");
										rcode_flag = true;
									} else if (data.msg == 'randomcode_error') {
										$("#errorspan")
												.html(
														"<font color='red'> 验证码错误！</font>");
										rcode_flag = true;
									} else if (data.msg == 'authentication_error') {
										$("#errorspan")
												.html(
														"<font color='red'> 您没有授权！</font>");
										rcode_flag = true;
									} else {
										location.href = "${baseurl}home";
									}
								},
								error : function() {
									// view("异常！");  
									alert("异常！");
								}
							});
				}
			}
		});
	</script>
</body>
</html>