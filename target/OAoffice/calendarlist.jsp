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
<title>用户总数--layui后台管理模板</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="layui/css/layui.css" media="all" />
<link rel="stylesheet" href="css/font_eolqem241z66flxr.css" media="all" />
<link rel="stylesheet" href="css/user.css" media="all" />
<script src="layer/layer.js"></script>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
	        function addcalendar(){
	    	   location.href='calendarinsert.jsp';
	       }
	         function deletecalendar(id){
	    	   
	    	   if(confirm("确定要删除吗")){
	    		   location.href='CalendarServlet.do?oper=delete&id='+id;  
	    	   }
	       }
	       
	       function updatecalendar(id){

	    	   //alert(id);
	    	   location.href='CalendarServlet.do?powercode=calendar_update&oper=t_update&id='+id;
	    	   //location.href='studentupdate.jsp';
	    	   
	       }
	        function searchAjax(){
	    	    var searchKey=$("#searchKey").val();
	    	    
				$.ajax({
					type:"post",
					data:{"searchKey":searchKey,"oper":"searchAjax"},
					url:"CalendarServlet.do",
					dataType:"json",
					async:true,
					success:function(data){
						//列表展示
						var ulist=data.list;
						var msg=data.msg;
						//拼接HTML
						var cont="";
						for(var i=0;i<ulist.length;i++){
							var s=ulist[i];
							
							cont+="<tr>";
							cont+="<td>";
							cont+=s.calendar_id ;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.calendar_title;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.calendar_starttime;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.calendar_endtime;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.calendar_remind;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.calendar_content;
							cont+="</td>";
							
							cont+="<td>";
							cont+="<button onclick=\"updatecalendar(${s.calendar_id })\"  class=\"layui-btn layui-btn-xs\">修改</button>";
							cont+="<button onclick=\"deletecalendar(${s.calendar_id })\" class=\"layui-btn layui-btn-danger layui-btn-xs\">删除</button>";
							cont+="</td>";
							cont+="</tr>";
						}
						$("#ulist").html(cont);
						
					}
				});
			}  
</script>
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote news_search">
		<div class="layui-inline">
			<div class="layui-input-inline">
				<input id="searchKey" name="searchKey"
					class="layui-input search_input" type="text" />
				<!--  <input type="text" id="searchKey" name="searchKey" value=""
					placeholder="请输入关键字" class="layui-input search_input"> -->
			</div>
			<a onclick="searchAjax()" class="layui-btn search_btn">查询</a>
		</div>
		<div class="layui-inline">
			<a onclick="addcalendar()"
				class="layui-btn layui-btn-normal calendarsAdd_btn">添加日程</a>
		</div>
	</blockquote>
	<div class="layui-form news_list">
		<table class="layui-table">
		    <colgroup>
				<col width="5%">
				<col width="15%">
				<col width="10%">
				<col width="10%">
				<col width="18%">
				<col width="18%">
				<col width="50">
				<col width="18%">
		    </colgroup>
			<thead>
				<tr>
					<th>id</th>
					<th>日程标题</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>提醒</th>
					<th>内容</th>
					<!-- <th>用户id</th> -->
					<th>操作</th>
				</tr>
			</thead>
			<tbody id=ulist class="calendars_content">
				<c:forEach items="${ulist }" var="s">
				   <c:set var="User_id" scope="session" value="${loginUser_id }"/>
				   <c:if test="${s.user_id==User_id }">
					<tr>
						<td>${s.calendar_id }</td>
						<td>${s.calendar_title }</td>
						<td>${s.calendar_starttime }</td>
						<td>${s.calendar_endtime }</td>
						<td>${s.calendar_remind }</td>
						<td>${s.calendar_content }</td>
						<%-- <td>${s.user_id }</td> --%>
						<td>
							<button onclick="updatecalendar(${s.calendar_id })"
								class="layui-btn layui-btn-xs">修改</button>
							<button onclick="deletecalendar(${s.calendar_id })"
								class="layui-btn layui-btn-danger layui-btn-xs">删除</button>
						</td>
					</tr>
				</c:if>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<div id="page"></div>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/allUsers.js"></script>
</body>
</html>