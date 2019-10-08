<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>个人资料--layui后台管理模板</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="layui/css/layui.css" media="all" />
<link rel="stylesheet" href="css/user.css" media="all" />
</head>
<body class="childrenBody">
	<form action="BulletinServlet.do" role="form" method="post"
		class="layui-form">
		<input type=hidden name="oper" value="add" />
		<div class="user_left">
			<div class="layui-form-item">
				<label class="layui-form-label">公告标题</label>
				<div class="layui-input-block">
					<input name="name" id="name" type="text" value=""
						placeholder="请输入公告标题" lay-verify="required" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">公告内容</label>
				<div class="layui-input-block">
					<input name="content" id="content" type="text" value=""
						placeholder="请输入公告内容" lay-verify="required" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">创建时间</label>
				<div class="layui-input-block">
					<input name="start" id="start" type="text" value=""
						placeholder="请输入创建时间" lay-verify="required|date"
						onclick="layui.laydate({elem: this,max: laydate.now()})" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">发起人名字</label>
				<div class="layui-input-block">
					<input name="realname" id="realname" type="tel" value="${loginUser }"
						placeholder="请输入名字" lay-verify="required|phone"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">发起人id</label>
				<div class="layui-input-block">
					<input name="user_id" id="user_id" type="text" value="${loginUser_id }" disabled
						placeholder="请输入id" lay-verify="required" class="layui-input">
				</div>
			</div>
		</div>

		<div class="layui-form-item" style="margin-left: 5%;">
			<div class="layui-input-block">
				<button type="submit" class="layui-btn">提交</button>
				<!-- <button class="layui-btn" lay-submit="" lay-filter="changeUser">立即提交</button> -->
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/address.js"></script>
	<script type="text/javascript" src="js/user.js"></script>
</body>
</html>