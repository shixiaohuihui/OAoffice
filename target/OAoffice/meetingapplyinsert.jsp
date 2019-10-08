<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	int user_id = (Integer) session.getAttribute("loginUser_id");
%>
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
<script type="text/javascript">
	function provingId() {
		var time = $("#time").val();
		var reason = $("#reason").val();
		var user_id = $("#user_id").val();
		$.ajax({
			type : "get",
			data : {
				"time" : time,
				"reason" : reason,
				"user_id" : user_id,
				"oper" : "add"
			},
			url : "MeetingapplyServlet.do",
			dataType : "json",
			async : true,
			success : function(data) {
				if (data.status == "1") {
					layer.msg("申请成功");
					//进入首页
					location.href = "MeetingapplyServlet.do";
				} else {
					layer.msg("申请失败");
				}
			}
		});

	}
</script>
</head>
<body class="childrenBody">
	<form action="MeetingapplyServlet.do" role="form" method="post"
		class="layui-form">
		<input type=hidden name="oper" value="add" />
		<div class="user_left">
			<div class="layui-form-item">
				<label class="layui-form-label">会议申请时间</label>
				<div class="layui-input-block">
					<input name="time" id="time" type="text" value=""
						placeholder="请输入会议申请时间" lay-verify="required|date"
						onclick="layui.laydate({elem: this,max: laydate.now()})"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">会议申请原因</label>
				<div class="layui-input-block">
					<input name="reason" id="reason" type="text" value=""
						placeholder="请输入请假原因" lay-verify="required" class="layui-input">
				</div>
			</div>
			<!-- <div class="layui-form-item">
				<label class="layui-form-label">发起人名字</label>
				<div class="layui-input-block">
					<input name="realname" id="realname" type="tel" value=""
						placeholder="请输入名字" lay-verify="required|phone"
						class="layui-input">
				</div>
			</div> -->
			<div class="layui-form-item">
				<label class="layui-form-label">会议申请人id</label>
				<div class="layui-input-block">
					<input name="user_id" id="user_id" type="text"
						value="${loginUser_id }" disabled placeholder="您的id"
						lay-verify="required" class="layui-input">
				</div>
			</div>
		</div>

		<div class="layui-form-item" style="margin-left: 5%;">
			<div class="layui-input-block">
				<!-- <button type="submit" class="layui-btn">提交</button> -->
				<button onclick="provingId()" type="button" class="layui-btn">提交</button>
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