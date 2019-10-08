<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String user_name = (String) session.getAttribute("loginUser_name");
	String user_pwd = (String) session.getAttribute("loginUser_pwd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改密码</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="layui/css/layui.css" media="all" />
<link rel="stylesheet" href="css/user.css" media="all" />
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="layer/layer.js"></script>
<script type="text/javascript">
	function changePwd() {
		var id = $("#id").val();
		var name=$("#name").val();
		var old=$("#old").val();
		var pwd = $("#pwd").val();
		var pwdagain = $("#pwdagain").val();
		if(<%=user_pwd%>==old&&old!=null){
		if (pwd != pwdagain) {
				layer.msg("修改失败！两次密码不一致");
			} else {
				//采用Ajax方式进行访问服务器
				$.ajax({
					type : "get",
					data : {
						"id" : id,
						"name" : name,
						"pwd" : pwd,
						"pwdagain" : pwdagain,
						"oper" : "changePwdAjax"
					},
					url : "UserServlet.do?powercode=user_pwd",
					dataType : "json",
					async : true,
					success : function(data) {
						if (data.status == "1") {
							layer.msg("修改成功,重新登录");
							//进入首页
							top.location.href = "UserServlet.do?powercode=user_pwd&oper=loginout";
						} else {
							layer.msg("修改失败");
						}
					}
				});
			}
		} else {
			layer.msg("原始密码不正确或密码为空！不能修改");
		}

	}
</script>
</head>
<body class="childrenBody">
	<form class="layui-form changePwd">
		<input name="id" id="id" type=hidden value="${loginUser_id }">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-block">
				<input id="name" type="text" value="<%=user_name%>" disabled
					class="layui-input layui-disabled">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">旧密码</label>
			<div class="layui-input-block">
				<input id="old" type="password" value="<%=user_pwd%>" disabled
					placeholder="请输入旧密码" lay-verify="required|oldPwd"
					class="layui-input pwd">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">新密码</label>
			<div class="layui-input-block">
				<input id="pwd" type="password" value="" placeholder="请输入新密码"
					lay-verify="required|newPwd" id="oldPwd" class="layui-input pwd">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">确认密码</label>
			<div class="layui-input-block">
				<input id="pwdagain" type="password" value="" placeholder="请确认密码"
					lay-verify="required|confirmPwd" class="layui-input pwd">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button onclick="changePwd()" type="button" class="layui-btn">立即修改</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/address.js"></script>
	<script type="text/javascript" src="js/user.js"></script>
</body>
</html>