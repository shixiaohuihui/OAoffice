<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>OA办公管理系统</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="icon" href="favicon.ico">
<link rel="stylesheet" href="layui/css/layui.css" media="all" />
<link rel="stylesheet" href="css/font_eolqem241z66flxr.css" media="all" />
<link rel="stylesheet" href="css/main.css" media="all" />
<link rel="stylesheet" href="iconfont/iconfont.css" media="all" />
</head>
<body class="main_body">
	<div class="layui-layout layui-layout-admin">
		<!-- 顶部 -->
		<div class="layui-header header">
			<div class="layui-main">
				<a href="#" class="logo">OA办公管理系统</a>
				<!-- 天气信息 -->
				<div class="weather">
					<div id="tp-weather-widget"></div>
					<script>
						(function(T, h, i, n, k, P, a, g, e) {
							g = function() {
								P = h.createElement(i);
								a = h.getElementsByTagName(i)[0];
								P.src = k;
								P.charset = "utf-8";
								P.async = 1;
								a.parentNode.insertBefore(P, a)
							};
							T["ThinkPageWeatherWidgetObject"] = n;
							T[n] || (T[n] = function() {
								(T[n].q = T[n].q || []).push(arguments)
							});
							T[n].l = +new Date();
							if (T.attachEvent) {
								T.attachEvent("onload", g)
							} else {
								T.addEventListener("load", g, false)
							}
						}(window, document, "script", "tpwidget",
								"//widget.seniverse.com/widget/chameleon.js"))
					</script>
					<script>
						tpwidget("init", {
							"flavor" : "slim",
							"location" : "WX4FBXXFKE4F",
							"geolocation" : "enabled",
							"language" : "zh-chs",
							"unit" : "c",
							"theme" : "chameleon",
							"container" : "tp-weather-widget",
							"bubble" : "disabled",
							"alarmType" : "badge",
							"color" : "#FFFFFF",
							"uid" : "U9EC08A15F",
							"hash" : "039da28f5581f4bcb5c799fb4cdfb673"
						});
						tpwidget("show");
					</script>
				</div>
				<!-- 顶部右侧菜单 -->
				<ul class="layui-nav top_menu">
					<li class="layui-nav-item showNotice" id="showNotice"><a
						href="javascript:;"><i class="iconfont icon-gonggao"></i><cite>系统公告</cite></a>
					</li>
					<li class="layui-nav-item lockcms"><a href="javascript:;"><i
							class="iconfont icon-lock1"></i><cite>锁屏</cite></a></li>
					<li class="layui-nav-item"><a href="javascript:;"> <img
							src="images/${loginHeadpic }" class="layui-circle" width="35" height="35">
							<cite>${loginUser }</cite>
					</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" data-url="userInfo.jsp"><i
									class="iconfont icon-zhanghu" data-icon="icon-zhanghu"></i><cite>个人信息</cite></a>
							</dd>
							<dd>
								<a href="javascript:;" data-url="changepwd.jsp"><i
									class="iconfont icon-shezhi1" data-icon="icon-shezhi1"></i><cite>修改密码</cite></a>
							</dd>
							<dd>
								<a href="UserServlet.do?powercode=logout&oper=logout" data-url=""><i
									class="iconfont icon-loginout"></i><cite>退出</cite></a>
							</dd>
						</dl></li>
				</ul>
			</div>
		</div>
		<!-- 左侧导航 -->
		<div class="layui-side layui-bg-black">
			<div class="user-photo">
				<a class="img" title="我的头像"><img src="images/${loginHeadpic }" width="110" height="110"></a>
				<p>
					你好！<span class="userName">${loginUser }</span>, 欢迎登录
				</p>
			</div>
			<div class="navBar layui-side-scroll" style="height: 478px;">
				<ul class="layui-nav layui-nav-tree">
					<li class="layui-nav-item" style=""><a href="javascript:;"
						data-url="main.html"> <i class="iconfont icon-computer"
							data-icon="icon-computer"></i> <cite>首页</cite></a></li>

					<li class="layui-nav-item" style=""><a href="javascript:;"><i
							class="layui-icon icon-xitongpeizhi"
							data-icon="icon-xitongpeizhi"></i><cite>个人办公</cite><span
							class="layui-nav-more"></span></a>

						<dl class="layui-nav-child">
							<%-- <dd class="">
								<a href="javascript:;" data-url="userInfo.jsp"> <i class="layui-icon"
									data-icon=""> </i><cite>个人信息</cite></a>
							</dd>
							<dd class="">
								<a href="javascript:;" data-url="CalendarServlet.do"> <i class="layui-icon"
									data-icon=""></i><cite>日程安排</cite></a>
							</dd>
							<dd class="">
								<a href="javascript:;" data-url="DothingServlet.do"> <i class="layui-icon"
									data-icon=""> </i><cite>代办事宜</cite></a>
							</dd>
							<dd class="">
								<a href="javascript:;" data-url="BulletinServlet.do"> <i class="layui-icon"
									data-icon=""></i><cite>消息提醒</cite></a>
							</dd>
							<dd class="">
								<a href="javascript:;" data-url="businesscard.jsp"> <i class="layui-icon"
									data-icon=""></i><cite>名片夹</cite></a>
							</dd>
							<dd class="">
								<a href="javascript:;" data-url="FloderServlet.do"> <i class="layui-icon"
									data-icon=""> </i><cite>个人文件夹</cite></a>
							</dd> --%>

							<c:forEach items="${allpowerlist }" var="power">
								<c:if test="${power.power_ismenu eq '1'}">
                                    <dd class="">
										<a href="javascript:;" data-url="${power.power_url }"> <i
											class="layui-icon" data-icon=""> 
											</i><cite>${power.power_name }</cite></a>
									</dd>
								</c:if>
							</c:forEach>

						</dl></li>


					<li class="layui-nav-item" style=""><a href="javascript:;"><i
							class="layui-icon icon-gongzuoliucheng"
							data-icon="icon-gongzuoliucheng"></i><cite>工作流程</cite><span
							class="layui-nav-more"></span></a>
						<dl class="layui-nav-child">
							<%-- <dd class="">
								<a href="javascript:;" data-url="VacateServlet.do"> <i
									class="layui-icon" data-icon=""> </i><cite>请假申请</cite></a>
							</dd>
							<dd class="">
								<a href="javascript:;" data-url="MeetingapplyServlet.do"> <i
									class="layui-icon" data-icon=""></i><cite>会议申请</cite></a>
							</dd>
							<dd class="">
								<a href="javascript:;" data-url="meetingapply.html"> <i
									class="layui-icon" data-icon=""></i><cite>二级会议审批</cite></a>
							</dd> --%>
							<c:forEach items="${allpowerlist }" var="power">
								<c:if test="${power.power_ismenu eq '2'}">
                                    <dd class="">
										<a href="javascript:;" data-url="${power.power_url }"> <i
											class="layui-icon" data-icon=""> 
											</i><cite>${power.power_name }</cite></a>
									</dd>
								</c:if>
							</c:forEach>
							
						</dl></li>


					<li class="layui-nav-item" style=""><a href="javascript:;"><i
							class="iconfont icon-text" data-icon="icon-text"></i><cite>行政办公</cite><span
							class="layui-nav-more"></span></a>
						<dl class="layui-nav-child">
							<%-- <dd class="">
								<a href="javascript:;" data-url="meeting.html"> <i
									class="layui-icon" data-icon="  "> </i><cite>会议管理</cite></a>
							</dd>
							<dd class="">
								<a href="javascript:;" data-url="meetingroom.html"> <i
									class="layui-icon" data-icon=""></i><cite>会议室管理</cite></a>
							</dd> --%>
							<c:forEach items="${allpowerlist }" var="power">
								<c:if test="${power.power_ismenu eq '3'}">
                                    <dd class="">
										<a href="javascript:;" data-url="${power.power_url }"> <i
											class="layui-icon" data-icon=""> 
											</i><cite>${power.power_name }</cite></a>
									</dd>
								</c:if>
							</c:forEach>
						</dl></li>

					<li class="layui-nav-item" style=""><a href="javascript:;"><i
							class="layui-icon" data-icon=""></i><cite>系统管理</cite><span
							class="layui-nav-more"></span></a>
						<dl class="layui-nav-child">
							<%--  <dd class="">
								<a href="javascript:;" data-url="UserServlet.do"> <i
									class="layui-icon" data-icon=""> </i><cite>用户管理</cite></a>
							</dd>
							<dd class="">

								<a href="javascript:;" data-url="dept.html"> <i
									class="layui-icon" data-icon=""></i><cite>部门管理</cite></a>

								<a href="javascript:;" data-url="DeptServlet.do"> <i class="layui-icon"
									data-icon=""></i><cite>部门管理</cite></a>

							</dd>
							<dd class="">
								<a href="javascript:;" data-url=""> <i class="layui-icon"
									data-icon=""></i><cite>角色及权限管理</cite></a>
							</dd> --%>  
							
							<c:forEach items="${allpowerlist }" var="power">
								<c:if test="${power.power_ismenu eq '4'}">
                                    <dd class="">
										<a href="javascript:;" data-url="${power.power_url }"> <i
											class="layui-icon" data-icon=""> 
											</i><cite>${power.power_name }</cite></a>
									</dd>
								</c:if>
							</c:forEach>
						</dl></li>



					<!-- <li class="layui-nav-item" style=""><a href="javascript:;"
						data-url="page/news/newsList.html"> <i
							class="iconfont icon-text" data-icon="icon-text"></i> <cite>文章列表</cite></a></li> -->


					<!-- <li class="layui-nav-item" style=""><a href="javascript:;"
						data-url="page/links/linksList.html"> <i
							class="iconfont icon-text" data-icon="icon-text"></i> <cite>友情链接</cite></a></li>


					<li class="layui-nav-item" style=""><a href="javascript:;"
						data-url="page/404.html"> <i class="layui-icon" data-icon="">
								</i><cite>404页面</cite></a></li>


					<li class="layui-nav-item layui-this" style=""><a
						href="javascript:;"
						data-url="page/systemParameter/systemParameter.html"> <i
							class="layui-icon" data-icon=""></i><cite>系统基本参数</cite></a></li>


					<li class="layui-nav-item" style=""><a href="javascript:;"><i
							class="layui-icon" data-icon=""> </i><cite>二级菜单演示</cite><span
							class="layui-nav-more"></span></a>
						<dl class="layui-nav-child">
							<dd class="">
								<a href="javascript:;" data-url=""> <i class="layui-icon"
									data-icon=""> </i><cite>二级菜单1</cite></a>
							</dd>
							<dd class="">
								<a href="javascript:;" data-url=""> <i class="layui-icon"
									data-icon=""></i><cite>二级菜单2</cite></a>
							</dd>
						</dl></li> -->
					<!-- <span class="layui-nav-bar"
						style="top: 23px; height: 0px; opacity: 0;"></span> -->
							

				</ul>
			</div>
		</div>
		<!-- 右侧内容 -->
		<div class="layui-body layui-form">
			<div class="layui-tab marg0" lay-filter="bodyTab">
				<ul class="layui-tab-title top_tab">
					<li class="layui-this" lay-id=""><i
						class="iconfont icon-computer"></i> <cite>首页</cite></li>
				</ul>
				<div class="layui-tab-content clildFrame">
					<div class="layui-tab-item layui-show">
						<iframe src="main.jsp"></iframe>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 锁屏 -->
	<div class="admin-header-lock" id="lock-box" style="display: none;">
		<div class="admin-header-lock-img">
			<img src="images/${loginHeadpic }" />
		</div>
		<div class="admin-header-lock-name" id="lockUserName">${loginUser }</div>
		<div class="input_btn">
			<input type="password" class="admin-header-lock-input layui-input"
				placeholder="请输入密码解锁.." name="lockPwd" id="lockPwd" />
			<button class="layui-btn" id="unlock">解锁</button>
		</div>
		<!-- <p>请输入“123456”，否则不会解锁成功哦！！！</p> -->
	</div>
	<!-- 移动导航 -->
	<div class="site-tree-mobile layui-hide">
		<i class="layui-icon">&#xe602;</i>
	</div>
	<div class="site-mobile-shade"></div>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/nav.js"></script>
	<script type="text/javascript" src="js/leftNav.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
</body>
</html>