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
		var name = $("#name").val();
		var content = $("#content").val();
		var path = $("#path").val();
		var share = $('input[type=radio][id=share]:checked').val();
		var user_id = $("#user_id").val();
		//采用Ajax方式进行访问服务器
		$.ajax({
			type : "get",
			data : {
				"id" : id,
				"name" : name,
				"content" : content,
				"path" : path,
				"share" : share,
				"user_id" : user_id,
				"oper" : "updateAjax"
			},
			url : "FloderServlet.do",
			dataType : "json",
			async : true,
			success : function(data) {
				if (data.status == "1") {
					layer.msg("修改成功");
					//进入首页
					location.href = "FloderServlet.do";
				} else {
					layer.msg("修改失败");
				}
			}
		});
	}
</script>
</head>
<body class="childrenBody">
	<form action="FloderServlet.do" role="form" method="post"
		class="layui-form">
		<input type=hidden name="oper" value="add" /> <input name="id"
			id="id" type=hidden value="${floder.floder_id }">
		<div class="user_left">
			<div class="layui-form-item">
				<label class="layui-form-label">文件名</label>
				<div class="layui-input-block">
					<input name="name" id="name" type="text" value="${floder.floder_name }"
						placeholder="" lay-verify="required" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">文件内容</label>
				<div class="layui-input-block">
					<input name="content" id="content" type="text" value="${floder.floder_content }"
						placeholder="" lay-verify="required" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">文件保存路径</label>
				<div class="layui-input-block">
					<input name="path" id="path" type="text" value="${floder.floder_path }"
						placeholder="" lay-verify="required" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">是否分享</label>
				<div class="layui-input-block">
					<input type="radio" name="share" id="share" value="0" title="不分享" checked>
					<input type="radio" name="share" id="share" value="1" title="分享">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">用户id</label>
				<div class="layui-input-block">
					<input name="user_id" id="user_id" type="text" value="${floder.user_id }" disabled
						placeholder="" lay-verify="required" class="layui-input">
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