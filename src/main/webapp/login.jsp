<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<title>login</title>
<link rel="stylesheet" type="text/css" href="static/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="static/css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="static/css/component.css" />
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#login").mousedown(function() {
			$("#login").css({"background":"red"});
		});
		$("#login").mouseup(function(){
			$("#login").css({"background":"#0096e6"});
		});
	});
	function loginAjax() {

		var logname = $("#logname").val();
		var logpass = $("#logpass").val();
		//采用Ajax方式进行访问服务器
		$.ajax({
			type : "get",
			data : {
				"logname" : logname,
				"logpass" : logpass,
				"oper" : "loginAjax"
			},
			url : "UserServlet.do",
			dataType : "json",
			async : true,
			success : function(data) {
				if (data.status == "1") {
					layer.alert('登录成功');
					//进入首页
					location.href = "index.jsp";
				} else {
					layer.msg(data.msg, function(){
						//关闭后的操作
						});
				}
			}
		});
	}
</script>
</head>
<body>
	<div class="container demo-1">
		<div class="content">
			<div id="large-header" class="large-header">
				<canvas id="demo-canvas"></canvas>
				<div class="logo_box">
					<h3>OA办公管理系统</h3>
					<form action="UserServlet.do" name="f" method="post">
						<div class="input_outer">
							<span class="u_user"></span> <input id="logname" name="logname"
								class="text" style="color: #FFFFFF !important" type="text"
								placeholder="请输入账户">
						</div>
						<div class="input_outer">
							<span class="us_uer"></span> <input id="logpass" name="logpass"
								class="text"
								style="color: #FFFFFF !important; position: absolute; z-index: 100;"
								value="" type="password" placeholder="请输入密码">
						</div>
						<div class="mb2">
							<a onclick="loginAjax()" class="act-but submit"
								style="color: #FFFFFF" id="login">登录</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /container -->
	<script src="static/js/tweenlite.min.js"></script>
	<script src="static/js/easepack.min.js"></script>
	<script src="static/js/raf.js"></script>
	<script src="static/js/demo-1.js"></script>
	<script src="layer/layer.js"></script>
</body>
</html>