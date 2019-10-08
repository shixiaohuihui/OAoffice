<%@page import="com.oaoffice.bean.Meetingapply"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <% int id=(int)session.getAttribute("loginUser_id"); %> --%>
<%
	int user_id = (Integer) session.getAttribute("loginUser_id");
	int role_id = (Integer) session.getAttribute("role_id");
	String realname = (String) session.getAttribute("loginUser");
%>
<%
	List<Meetingapply> ulist = (List) request.getAttribute("ulist");
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
	        function addmeetingapply(){
	    	   location.href='meetingapplyinsert.jsp';
	       }
	         function deletemeetingapply(id){
	    	  
	    	   if(confirm("确定要删除吗")){
	    		   location.href='MeetingapplyServlet.do?oper=delete&id='+id;  
	    	   }
	       }
	       
	       function updatemeetingapply(id){
	    	   
	    	   location.href='MeetingapplyServlet.do?powercode=user_meetingapproval&oper=t_update&id='+id;
	    	   //location.href='studentupdate.jsp';
	    	   
	       }
	       function updatemeetingapplytwo(id){
	    	  
	    	   location.href='MeetingapplyServlet.do?powercode=user_two&oper=t_updateTwo&id='+id;
	    	   //location.href='studentupdate.jsp';
	    	   
	       }
	        function searchAjax(){
	    	   
	    	    var searchKey=$("#searchKey").val();
	    	    //alert(searchKey);
	    	    
				$.ajax({
					type:"post",
					data:{"searchKey":searchKey,"oper":"searchAjax"},
					url:"MeetingapplyServlet.do",
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
							cont+=s.meetingapply_id ;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.meetingapply_time;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.meetingapply_reason;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.user_realname;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.approver;
							cont+="</td>";
							
							
							cont+="<td>";
							cont+=s.meetingapply_state;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.twoapprover;
							cont+="</td>";
							
							
							cont+="<td>";
							cont+=s.twomeetingapply_state;
							cont+="</td>";
							
							cont+="<td>";
							cont+="<button onclick=\"updatemeetingapply(${s.meetingapply_id })\"  class=\"layui-btn layui-btn-xs\">审批</button>";
							/* cont+="<button onclick=\"deletemeetingapply(${s.meetingapply_id })\" class=\"layui-btn layui-btn-danger layui-btn-xs\">删除</button>"; */
							cont+="<button onclick=\"updatemeetingapplytwo(${s.meetingapply_id })\" class=\"layui-btn layui-btn-xs\">二级审批</button>";
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
			<a onclick="addmeetingapply()"
				class="layui-btn layui-btn-normal meetingapplysAdd_btn">会议申请</a>
		</div>
	</blockquote>
	<div class="layui-form news_list">
		<table class="layui-table">
			<colgroup>
				<col width="5%">
				<col width="10%">
				<col width="18%">
				<col width="7%">
				<col width="10%">
				<col width="8%">
				<col width="10%">
				<col width="8%">
				<col width="17%">
			</colgroup>
			<thead>
				<tr>
					<th>id</th>
					<th>会议申请时间</th>
					<th>会议申请原因</th>
					<th>申请人</th>
					<th>审批人(一级)</th>
					<th>审批结果</th>
					<th>审批人(二级)</th>
					<th>审批结果</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id=ulist class="meetingapplys_content">
				<%-- <c:forEach items="${ulist }" var="s">
				   <c:if test="${s.user_id==M }">
					<tr>
						<td>${s.meetingapply_id }</td>
						<td>${s.meetingapply_sharttime }</td>
						<td>${s.meetingapply_time }</td>
						<td>${s.meetingapply_reason }</td>
						<td>${s.user_id }</td>
						<td>${s.approver }</td>
						<td>${s.meetingapply_state }</td>
						<td>
							<button onclick="updatemeetingapply(${s.meetingapply_id })"
								class="layui-btn layui-btn-xs">修改</button>
							<button onclick="deletemeetingapply(${s.meetingapply_id })"
								class="layui-btn layui-btn-danger layui-btn-xs">删除</button>
						</td>
					</tr>
					</c:if>
				</c:forEach> --%>

				<%
					if (ulist != null) {
						for (int i = 0; i < ulist.size(); i++) {
							Meetingapply meetingapply = ulist.get(i);
							if (role_id == 3 && meetingapply.getMeetingapply_id() != 0) {
				%>
				<tr>
					<td><%=meetingapply.getMeetingapply_id()%></td>
					<td><%=meetingapply.getMeetingapply_time()%></td>
					<td><%=meetingapply.getMeetingapply_reason()%></td>
					<td><%=meetingapply.getUser_realname()%></td>
					<td><%=meetingapply.getApprover()%></td>
					<td><%=meetingapply.getMeetingapply_state()%></td>
					<td><%=meetingapply.getTwoapprover()%></td>
					<td><%=meetingapply.getTwomeetingapply_state()%></td>
					<td>
						<button
							onclick="updatemeetingapply(<%=meetingapply.getMeetingapply_id()%>)"
							class="layui-btn layui-btn-xs">审批</button>
						<button
							onclick="updatemeetingapplytwo(<%=meetingapply.getMeetingapply_id()%>)"
							class="layui-btn layui-btn-xs">二级审批</button> <%-- <button
							onclick="deletemeetingapply(<%=meetingapply.getMeetingapply_id()%>)"
							class="layui-btn layui-btn-danger layui-btn-xs">删除</button> --%>
					</td>
				</tr>
				<%
					} else if (role_id == 4 && meetingapply.getMeetingapply_id() != 0&&meetingapply.getMeetingapply_state().equals("同意")) {
				%>
				<tr>
					<td><%=meetingapply.getMeetingapply_id()%></td>
					<td><%=meetingapply.getMeetingapply_time()%></td>
					<td><%=meetingapply.getMeetingapply_reason()%></td>
					<td><%=meetingapply.getUser_realname()%></td>
					<td><%=meetingapply.getApprover()%></td>
					<td><%=meetingapply.getMeetingapply_state()%></td>
					<td><%=meetingapply.getTwoapprover()%></td>
					<td><%=meetingapply.getTwomeetingapply_state()%></td>
					<td>
						<button
							onclick="updatemeetingapply(<%=meetingapply.getMeetingapply_id()%>)"
							class="layui-btn layui-btn-xs">审批</button>
						<button
							onclick="updatemeetingapplytwo(<%=meetingapply.getMeetingapply_id()%>)"
							class="layui-btn layui-btn-xs">二级审批</button> <%-- <button
							onclick="deletemeetingapply(<%=meetingapply.getMeetingapply_id()%>)"
							class="layui-btn layui-btn-danger layui-btn-xs">删除</button> --%>
					</td>
				</tr>



				<%
					} else if (meetingapply.getUser_id() == user_id) {
				%>
				<tr>
					<td><%=meetingapply.getMeetingapply_id()%></td>
					<td><%=meetingapply.getMeetingapply_time()%></td>
					<td><%=meetingapply.getMeetingapply_reason()%></td>
					<%-- <td><%=meetingapply.getUser_id()%></td> --%>
					<td><%=realname%></td>
					<td><%=meetingapply.getApprover()%></td>
					<td><%=meetingapply.getMeetingapply_state()%></td>
					<td><%=meetingapply.getTwoapprover()%></td>
					<td><%=meetingapply.getTwomeetingapply_state()%></td>
					<td>
						<button
							onclick="updatemeetingapply(<%=meetingapply.getMeetingapply_id()%>)"
							class="layui-btn layui-btn-xs">审批</button>
						<button
							onclick="updatemeetingapplytwo(<%=meetingapply.getMeetingapply_id()%>)"
							class="layui-btn layui-btn-xs">二级审批</button> <%-- <button
							onclick="deletemeetingapply(<%=meetingapply.getMeetingapply_id()%>)"
							class="layui-btn layui-btn-danger layui-btn-xs">删除</button> --%>
					</td>
				</tr>
				<%
					}
						}
					}
				%>
			</tbody>
		</table>
	</div>
	<div id="page"></div>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/allUsers.js"></script>
</body>
</html>