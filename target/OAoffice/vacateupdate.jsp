<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="layer/layer.js"></script>
<script type="text/javascript">
	function updateAjax() {
		var id = $("#id").val();
		var start = $("#start").val();
		var time = $("#time").val();
		var reason = $("#reason").val();
		var user_id = $("#user_id").val();
		var approver = $("#approver").val();
		var state = $('input[type=radio][id=state]:checked').val();
		//采用Ajax方式进行访问服务器
		$.ajax({
			type : "get",
			data : {
				"id" : id,
				"start" : start,
				"time" : time,
				"reason" : reason,
				"user_id" : user_id,
				"approver" : approver,
				"state" : state,
				"oper" : "updateAjax"
			},
			url : "VacateServlet.do",
			dataType : "json",
			async : true,
			success : function(data) {
				if (data.status == "1") {
					layer.msg("审批成功");
					//进入首页
					location.href = "VacateServlet.do";
				} else {
					layer.msg("审批失败");
				}
			}
		});
	}
</script>
</head>
<body class="childrenBody">
	<form action="VacateServlet.do" role="form" method="post"
		class="layui-form">
		<input type=hidden name="oper" value="add" /> <input name="id"
			id="id" type=hidden value="${vacate.vacate_id }">
		<div class="user_left">
			<div class="layui-form-item">
				<label class="layui-form-label">什么时候请假</label>
				<div class="layui-input-block">
					<input name="start" id="start" type="text"
						value="${vacate.vacate_sharttime }" disabled placeholder="请输入请假时间"
						lay-verify="required" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">请假多久</label>
				<div class="layui-input-block">
					<input name="time" id="time" type="text"
						value="${vacate.vacate_time}" disabled placeholder="请输入公告内容"
						lay-verify="required" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">请假原因</label>
				<div class="layui-input-block">
					<input name="reason" id="reason" type="text"
						value="${vacate.vacate_reason }" disabled placeholder="请输入请假原因"
						lay-verify="required" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">请假人</label>
				<div class="layui-input-block">
					<input name="user_id" id="user_id" type="text"
						value="${vacate.user_id }" disabled placeholder=""
						lay-verify="required" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">审批人</label>
				<div class="layui-input-block">
					<input name="approver" id="approver" type="text"
						disabled value="${loginUser }" placeholder="" lay-verify="required"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">审批结果</label>
				<div class="layui-input-block">
					<input type="radio" name="state" id="state" value="不同意" title="不同意" checked>
					<input type="radio" name="state" id="state" value="同意" title="同意">
				</div>
			</div>
		</div>

		<div class="layui-form-item" style="margin-left: 5%;">
			<div class="layui-input-block">
				<button onclick="updateAjax()" type="button" class="layui-btn">提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/address.js"></script>
	<script type="text/javascript" src="js/user.js"></script>
</body>
</html>