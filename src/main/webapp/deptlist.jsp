<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="layer/layer.js"></script>
<script type="text/javascript">
	       function addUser(){
	    	   location.href='deptinsert.jsp';
	       }
	       function deleteUser(id){
	    	   
	    	   if(confirm("确定要删除吗")){
	    		   location.href='DeptServlet.do?oper=delete&id='+id;  
	    	   }
	       }
	       function updateUser(id){
	    	   
	    	   location.href='DeptServlet.do?oper=update1&id='+id;
	    	   //location.href='studentupdate.jsp';
	    	   
	       }
	       function searchAjax(){
	    	    //alert(123);	    	  
	    	    var searchKey=$("#searchKey").val();
	    	    //alert(searchKey);
				$.ajax({
					type:"post",
					data:{"searchKey":searchKey,"oper":"searchAjax"},
					url:"DeptServlet.do",
					dataType:"json",
					async:true,
					success:function(data){
						//列表展示
						var dlist=data;
						
						//拼接HTML
						var cont="";
						for(var i=0;i<dlist.length;i++){
							var s=dlist[i];
							
							cont+="<tr>";
							cont+="<td>";
							cont+=s.dept_id ;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.dept_name;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.dept_description;
							cont+="</td>";
							
														
							cont+="<td>";
							cont+="<button onclick=\"updateUser(${s.dept_id })\"  class=\"layui-btn layui-btn-xs\">修改</button>";
							cont+="<button onclick=\"deleteUser(${s.dept_id })\" class=\"layui-btn layui-btn-danger layui-btn-xs\">删除</button>";
							cont+="</td>";
							cont+="</tr>";
						}
						$("#dlist").html(cont);
						
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
			<a onclick="addUser()"
				class="layui-btn layui-btn-normal usersAdd_btn">添加部门</a>
		</div>
	</blockquote>
	<div class="layui-form news_list">
		<table class="layui-table">
			<thead>
				<tr>
					<th>部门id</th>
					<th>部门名称</th>
					<th>部门简介</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id=dlist class="users_content">
				<c:forEach items="${dlist }" var="s">
					<tr>
						<td>${s.dept_id }</td>
						<td>${s.dept_name }</td>
						<td>${s.dept_description }</td>
						<td>
							<button onclick="updateUser(${s.dept_id })"
								class="layui-btn layui-btn-xs">修改</button>
							<button onclick="deleteUser(${s.dept_id })"
								class="layui-btn layui-btn-danger layui-btn-xs">删除</button>
                         </td>
                     </tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<div id="page"></div>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/allUsers.js"></script>
</body>
</html>