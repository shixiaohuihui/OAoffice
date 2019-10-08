<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>首页--layui后台管理模板</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="css/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="css/main.css" media="all" />
	<link rel="stylesheet" href="iconfont/iconfont.css" media="all" />
</head>
<body class="childrenBody">
	<div class="panel_box row">
		<div class="panel col">
			<a href="javascript:;" data-url="userInfo.jsp">
				<div class="panel_icon">
					<i class="iconfont" data-icon="&#xe63c;">&#xe63c;</i>
				</div>
				<div class="panel_word newMessage">
					<span></span>
					<cite>个人信息</cite>
				</div>
			</a>
		</div>
		
		<div class="panel col">
			<a href="javascript:;" data-url="CalendarServlet.do">
				<div class="panel_icon" style="background-color:#FF5722;">
					<i class="iconfont" data-icon="&#xe628;">&#xe628;</i>
				</div>
				<div class="panel_word userAll">
					<span></span>
					<cite>日程安排</cite>
				</div>
			</a>
		</div>
		<div class="panel col">
			<a href="javascript:;" data-url="DothingServlet.do">
				<div class="panel_icon" style="background-color:#009688;">
					<i class="iconfont" data-icon="&#xe66b;">&#xe66b;</i>
				</div>
				<div class="panel_word userAll">
					<span></span>
					<cite>代办事宜</cite>
				</div>
			</a>
		</div>
		<div class="panel col">
			<a href="javascript:;" data-url="businesscard.jsp">
				<div class="panel_icon" style="background-color:#5FB878;">
					<i class="iconfont" data-icon="&#xe600;">&#xe600;</i>
				</div>
				<div class="panel_word imgAll">
					<span></span>
					<cite>个人名片</cite>
				</div>
			</a>
		</div>
		
		<div class="panel col">
			<a href="javascript:;" data-url="FloderServlet.do">
				<div class="panel_icon" style="background-color:#F7B824;">
					<i class="iconfont" data-icon="&#xe60e;">&#xe60e;</i>
				</div>
				<div class="panel_word waitNews">
					<span></span>
					<cite>个人文件夹</cite>
				</div>
			</a>
		</div>
		
		<div class="panel col">
			<a href="javascript:;" data-url="User
			Servlet.do">
				<div class="panel_icon" style="background-color:#F7B824;">
					<i class="iconfont" data-icon="&#xe60e;">&#xe60e;</i>
				</div>
				<div class="panel_word waitNews">
					<span></span>
					<cite>通讯录</cite>
				</div>
			</a>
		</div>
		
		<div class="panel col max_panel">
			<a href="javascript:;" data-url="BulletinServlet.do">
				<div class="panel_icon" style="background-color:#2F4056;">
					<i class="iconfont" data-icon="&#xe88b;">&#xe88b;</i>
				</div>
				<div class="panel_word waitNews">
					<span></span>
					<cite>消息提醒</cite>
				</div>
			</a>
		</div>
		
		<div class="panel col max_panel">
			<a href="javascript:;" data-url="VacateServlet.do">
				<div class="panel_icon" style="background-color:#DB7093	;">
					<i class="iconfont" data-icon="&#xe66d;">&#xe66d;</i>
				</div>
				<div class="panel_word waitNews">
					<span></span>
					<cite>请假申请</cite>
				</div>
			</a>
		</div>
		
		<div class="panel col max_panel">
			<a href="javascript:;" data-url="MeetingapplyServlet.do">
				<div class="panel_icon" style="background-color:#DA70D6;">
					<i class="iconfont" data-icon="&#xe695;">&#xe695;</i>
				</div>
				<div class="panel_word waitNews">
					<span></span>
					<cite>会议申请</cite>
				</div>
			</a>
		</div>
		
		<!-- <div class="panel col max_panel">
			<a href="javascript:;" data-url="meetingapply.html">
				<div class="panel_icon" style="background-color:#800080;">
					<i class="iconfont" data-icon="&#xe695;">&#xe695;</i>
				</div>
				<div class="panel_word waitNews">
					<span></span>
					<cite>二级会议审批</cite>
				</div>
			</a>
		</div> -->
		
		<div class="panel col max_panel">
			<a href="javascript:;" data-url="MeetingServlet.do">
				<div class="panel_icon" style="background-color:#800000;">
					<i class="iconfont" data-icon="&#xe69b;">&#xe69b;</i>
				</div>
				<div class="panel_word waitNews">
					<span></span>
					<cite>会议管理</cite>
				</div>
			</a>
		</div>
		
		<div class="panel col max_panel">
			<a href="javascript:;" data-url="MeetingRoomServlet.do">
				<div class="panel_icon" style="background-color:#8B4513;">
					<i class="iconfont" data-icon="&#xe646;">&#xe646;</i>
				</div>
				<div class="panel_word waitNews">
					<span></span>
					<cite>会议室管理</cite>
				</div>
			</a>
		</div>
		
		<div class="panel col max_panel">
			<a href="javascript:;" data-url="UserServlet.do">
				<div class="panel_icon" style="background-color:#556B2F;">
					<i class="iconfont" data-icon="&#xe780;">&#xe780;</i>
				</div>
				<div class="panel_word waitNews">
					<span></span>
					<cite>用户管理</cite>
				</div>
			</a>
		</div>
		
		<div class="panel col max_panel">
			<a href="javascript:;" data-url="DeptServlet.do">
				<div class="panel_icon" style="background-color:#40E0D0;">
					<i class="iconfont" data-icon="&#xe605;">&#xe605;</i>
				</div>
				<div class="panel_word waitNews">
					<span></span>
					<cite>部门管理</cite>
				</div>
			</a>
		</div>
		
		<div class="panel col max_panel">
			<a href="javascript:;" data-url="PowerServlet.do">
				<div class="panel_icon" style="background-color:#00008B;">
					<i class="iconfont" data-icon="&#xe610;">&#xe610;</i>
				</div>
				<div class="panel_word waitNews">
					<span></span>
					<cite>角色及权限管理</cite>
				</div>
			</a>
		</div>
		
	</div>


	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
</body>
</html>