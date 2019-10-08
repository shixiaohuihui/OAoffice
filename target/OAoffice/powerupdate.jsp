<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<script type="text/javascript" src="layui/layui.js"></script>

</head>
<body class="childrenBody">
	<form action="PowerServlet.do" role="form" method="post"
		class="layui-form">
		<input type=hidden name="oper" value="update2" />
		<input type=hidden name="userid" value="${bean.user_id}" />
		<div class="user_left">
			<div class="layui-form-item">
				<label class="layui-form-label">id</label>
				<div class="layui-input-block">
					<input name="userid" id="userid" type="text"
						value="${bean.user_id}" lay-verify="required" class="layui-input"
						disabled="disabled">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">姓名</label>
				<div class="layui-input-block">
					<input name="realname" id="realname" type="text"
						value="${bean.user_realname}" lay-verify="required"
						class="layui-input" disabled="disabled">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">选择框</label>
				<div class="layui-input-block">
					<select name="roleid" lay-verify="required" id="roleid">
						<option value=""></option>
						<c:forEach items="${role}" var="s">
						<option value="${s.role_id}" <c:if test="${s.role_id == bean.role_id}">selected</c:if> >${s.role_name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="layui-form-item" style="margin-left: 5%;">
				<div class="layui-input-block">
					<button type="submit" class="layui-btn">提交</button>
					<!-- <button class="layui-btn" lay-submit="" lay-filter="changeUser">立即提交</button> -->
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		layui.use([ 'layer', 'form' ], function() {
			var layer = layui.layer, form = layui.form;
		});
	
	</script>
</body>
</html>