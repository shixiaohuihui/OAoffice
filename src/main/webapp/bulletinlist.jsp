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
	$(function(){
		layer.alert("${msg}");
	})
	function msg(str){
		layer.alert(str);
	}
	        function addbulletin(){
	    	   location.href='BulletinServlet.do?powercode=user_news&oper=t_add';
	       }
	         function deletebulletin(id){
	    	  
	    	   if(confirm("确定要删除吗")){
	    		   location.href='BulletinServlet.do?powercode=user_deletenews&oper=delete&id='+id;  
	    	   }
	       }
	       
	       function updatebulletin(id){
	    	   //alert(id);	    	  
	    	   location.href='BulletinServlet.do?powercode=user_updatenews&oper=t_update&id='+id;
	    	   //location.href='studentupdate.jsp';
    	   
	       }
	        function searchAjax(){
	    	    //alert(123);
	    	    var searchKey=$("#searchKey").val();
	    	    //alert(searchKey);
				$.ajax({
					type:"post",
					data:{"searchKey":searchKey,"oper":"searchAjax"},
					url:"BulletinServlet.do",
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
							cont+=s.bulletin_id ;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.bulletin_title;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.bulletin_content;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.bulletin_buildtime;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.user_realname;
							cont+="</td>";
							
							cont+="<td>";
							cont+="<button onclick=\"updatebulletin(${s.bulletin_id })\"  class=\"layui-btn layui-btn-xs\">修改</button>";
							cont+="<button onclick=\"deletebulletin(${s.bulletin_id })\" class=\"layui-btn layui-btn-danger layui-btn-xs\">删除</button>";
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
			<a onclick="addbulletin()"
				class="layui-btn layui-btn-normal bulletinsAdd_btn">发布消息</a>
		</div>
	</blockquote>
	<div class="layui-form news_list">
		<table class="layui-table">
			<colgroup>
				<col width="5%">
				<col width="10%">
				<col width="20%">
				<col width="12%">
				<col width="7%">
				<col width="15%">
			</colgroup>
			<thead>
				<tr>
					<th>id</th>
					<th>公告主题</th>
					<th>公告内容</th>
					<th>公告创建时间</th>
					<th>发起人名字</th>
					<!-- <th>发起人id</th> -->
					<th>操作</th>
				</tr>
			</thead>
			<tbody id=ulist class="bulletins_content">
				<c:forEach items="${ulist }" var="s">
					<tr onclick="msg('${s.bulletin_content }')">
						<td>${s.bulletin_id }</td>
						<td>${s.bulletin_title }</td>
						<td>${s.bulletin_content }</td>
						<td>${s.bulletin_buildtime }</td>
						<td>${s.user_realname }</td>
						<%-- <td>${s.user_id }</td> --%>
						<td>
							<button onclick="updatebulletin(${s.bulletin_id })"
								class="layui-btn layui-btn-xs">修改</button>
							<button onclick="deletebulletin(${s.bulletin_id })"
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