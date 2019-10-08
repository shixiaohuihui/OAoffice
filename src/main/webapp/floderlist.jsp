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
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
	        function addFloder(){
	    	   location.href='floderinsert.jsp';
	       }
	         function deleteFloder(id){
	    	   
	    	   if(confirm("确定要删除吗")){
	    		   location.href='FloderServlet.do?oper=delete&id='+id;  
	    	   }
	       }
	       
	       function updateFloder(id){
	    	   //alert(id);
	    	   location.href='FloderServlet.do?powercode=Floder_update&oper=t_update&id='+id;
	    	   //location.href='studentupdate.jsp';
	    	   
	       }
	        function searchAjax(){
	    	    //alert(123);
	    	    var searchKey=$("#searchKey").val();
	    	    //alert(searchKey);
				$.ajax({
					type:"post",
					data:{"searchKey":searchKey,"oper":"searchAjax"},
					url:"FloderServlet.do",
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
							if(s.floder_isshare==1){
							cont+="<tr>";
							cont+="<td>";
							cont+=s.floder_id ;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.floder_name;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.floder_content;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.floder_path;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.user_realname;
							cont+="</td>";
							
							cont+="<td>";
							
							cont+="</td>";
							
							cont+="<td>";
							cont+="<button onclick=\"updateFloder(${s.floder_id })\"  class=\"layui-btn layui-btn-xs\">修改</button>";
							cont+="<button onclick=\"deleteFloder(${s.floder_id })\" class=\"layui-btn layui-btn-danger layui-btn-xs\">删除</button>";
							cont+="</td>";
							cont+="</tr>";
						}
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
			<a onclick="searchAjax()" class="layui-btn search_btn">查询分享文件</a>
		</div>
		<div class="layui-inline">
			<a onclick="addFloder()"
				class="layui-btn layui-btn-normal FlodersAdd_btn">添加文件夹</a>
		</div>
	</blockquote>
	<div class="layui-form news_list">
		<table class="layui-table">
			<col width="5%">
			<col width="10%">
			<col width="20%">
			<col width="12%">
			<col width="7%">
			<col width="7%">
			<col width="15%">
			<thead>
				<tr>
					<th>id</th>
					<th>文件名</th>
					<th>文件内容</th>
					<th>文件保存路径</th>
					<!-- <th>是否分享</th> -->
					<th>用户姓名</th>
					<th>分享状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id=ulist class="Floders_content">
				<c:forEach items="${ulist }" var="s">
					<c:set var="User_id" scope="session" value="${loginUser_id }" />

					<c:if test="${s.user_id==User_id }">
						<tr>
							<td>${s.floder_id }</td>
							<td>${s.floder_name }</td>
							<td>${s.floder_content }</td>
							<td>${s.floder_path }</td>
							<td>${s.user_realname }</td>
							<%-- <td>${s.user_id }</td> --%>
							<td></td>
							<td>
								<button onclick="updateFloder(${s.floder_id })"
									class="layui-btn layui-btn-xs">修改</button>
								<button onclick="deleteFloder(${s.floder_id })"
									class="layui-btn layui-btn-danger layui-btn-xs">删除</button>
							</td>
						</tr>

					</c:if>
					<c:if test="${s.floder_isshare eq '1' }">
						<tr>
							<td>${s.floder_id }</td>
							<td>${s.floder_name }</td>
							<td>${s.floder_content }</td>
							<td>${s.floder_path }</td>
							<td>${s.user_realname }</td>
							<td>正在分享</td>
							<%-- <td>${s.user_id }</td> --%>
							<td>
								<%-- <button onclick="updateFloder(${s.floder_id })"
									class="layui-btn layui-btn-xs">修改</button>
								<button onclick="deleteFloder(${s.floder_id })"
									class="layui-btn layui-btn-danger layui-btn-xs">删除</button> --%>
								不可操作
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