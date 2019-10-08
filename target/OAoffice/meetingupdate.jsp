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
		var uname = $("#uname").val();
		var date = $("#date").val();
		var datestart = $("#datestart").val();
		var dateend = $("#dateend").val();
		var status = $("#status").val();
		var roomid = $("#roomid").val();

		//采用Ajax方式进行访问服务器
		$.ajax({
			type : "post",
			data : {
				"id" : id,
				"uname" : uname,
				"date" : date,
				"datestart" : datestart,
				"dateend" : dateend,
				"status" : status,
				"roomid" : roomid,
				"oper" : "updateAjax"
			},
			url : "MeetingServlet.do",
			dataType : "json",
			async : true,
			success : function(data) {
				if (data.status == "1") {
					layer.msg("修改成功");
					//进入首页
					location.href = "MeetingServlet.do";
				} else {
					layer.msg("修改失败");
				}
			}
		});
	}
</script>
</head>
<body class="childrenBody">
	<form action="MeetingServlet.do" role="form" method="post"
		class="layui-form">
		<input type=hidden name="oper" value="updateAjax" /> <input name="id"
			id="id" type=hidden value="${vMeeting.meeting_id }">
		<div class="user_left">
			<div class="layui-form-item">
				<label class="layui-form-label">会议名称</label>
				<div class="layui-input-block">
					<input name="uname" id="uname" type="text"
						value="${vMeeting.meeting_title }" placeholder="请输入会议名称"
						lay-verify="required" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">会议日期</label>
				<div class="layui-input-block">
					<input name="date" id="date" type="text"
						value="${vMeeting.meeting_date }" placeholder="请输入会议日期"
						lay-verify="required|date"
						onclick="layui.laydate({elem: this})"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">开始时间</label>
				<div class="layui-input-block">
					<input name="datestart" id="datestart" type="text"
						value="${vMeeting.meeting_start }" placeholder="请输入开始时间"
						lay-verify="required|date"
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'H:mm:ss'})"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">结束时间</label>
				<div class="layui-input-block">
					<input name="dateend" id="dateend" type="text"
						value="${vMeeting.meeting_end }" placeholder="请输入结束时间"
						lay-verify="required|date"
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'H:mm:ss'})"
						class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">会议状态</label>
				<div class="layui-input-block">
					<input name="status" id="status" type="text"
						value="${vMeeting.meeting_status }" placeholder="请输入会议状态"
						lay-verify="required" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">会议室ID</label>
				<div class="layui-input-block">
					<input name="roomid" id="roomid" type="text"
						value="${vMeeting.meetingroom_id }" placeholder="请输入会议室ID" disabled
						lay-verify="required" class="layui-input">
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
	<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>