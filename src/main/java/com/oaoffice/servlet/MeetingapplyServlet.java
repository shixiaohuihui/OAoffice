package com.oaoffice.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oaoffice.bean.Meetingapply;
import com.oaoffice.bean.User;
import com.oaoffice.bean.Vacate;
import com.oaoffice.service.MeetingapplyService;
import com.oaoffice.service.impl.MeetingapplyServiceImpl;
import com.oaoffice.util.Datetransform;

public class MeetingapplyServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MeetingapplyService meetingapplyService = new MeetingapplyServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// *******防止乱码
		// 输入数据乱码解决方案：使用request对象获取浏览器提交数据前，先设置字符集
		response.setCharacterEncoding("utf-8");

		// 输出数据乱码解决方案：使用request输出数据前，先设置字符集和内容类型
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		// response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		String oper = request.getParameter("oper");
		PrintWriter out = response.getWriter();
		System.out.println("ppp");
		if (oper != null) {
			if (oper.equals("add")) {
				// 获取表单数据
				Date time = Datetransform.parse(request.getParameter("time"), "yyyy-MM-dd");
				String reason = request.getParameter("reason");
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				String approver =" ";
				String state = " ";
				String twoapprover =" ";
				String twostate = " ";
				Meetingapply meetingapply = new Meetingapply(time,reason,user_id,approver,state,twoapprover,twostate);
				meetingapplyService.insert(meetingapply);
				out.println("{\"status\":\"1\"}");
				//List<Meetingapply> ulist = meetingapplyService.list();
				//request.setAttribute("ulist", ulist);
				//request.getRequestDispatcher("meetingapplylist.jsp").forward(request, response);
				
			} else if (oper.equals("delete")) {
				String id = request.getParameter("id");
				System.out.println(id);
				meetingapplyService.delete(Integer.parseInt(id));
				List<Meetingapply> ulist = meetingapplyService.list();
				request.setAttribute("ulist", ulist);
				request.getRequestDispatcher("meetingapplylist.jsp").forward(request, response);
			} else if (oper.equals("t_update")) {
				String id = request.getParameter("id");
				System.out.println(id);
				Meetingapply meetingapply = meetingapplyService.load(Integer.parseInt(id));
				request.setAttribute("meetingapply", meetingapply);
				request.getRequestDispatcher("meetingapplyupdate.jsp").forward(request, response);

			} else if (oper.equals("updateAjax")) {

				String id = request.getParameter("id");
				Date time = Datetransform.parse(request.getParameter("time"), "yyyy-MM-dd");
				String reason = request.getParameter("reason");
				int user_id= Integer.parseInt(request.getParameter("user_id"));
				String approver = request.getParameter("approver");
				String state = request.getParameter("state");
				String twoapprover =" ";
				String twostate = " ";
				Meetingapply meetingapply = new Meetingapply(time,reason,user_id,approver,state,twoapprover,twostate);
				meetingapply.setMeetingapply_id(Integer.parseInt(id));
				meetingapplyService.update(meetingapply);
				out.println("{\"status\":\"1\"}");

			}else if (oper.equals("t_updateTwo")) {
				String id = request.getParameter("id");
				System.out.println(id);
				Meetingapply meetingapply = meetingapplyService.load(Integer.parseInt(id));
				request.setAttribute("meetingapply", meetingapply);
				request.getRequestDispatcher("meetingapplyupdatetwo.jsp").forward(request, response);

			}else if (oper.equals("updateAjaxTwo")) {
                int id = Integer.parseInt(request.getParameter("id"));
                /*Date time = Datetransform.parse(request.getParameter("time"), "yyyy-MM-dd");
				String reason = request.getParameter("reason");
				int user_id= Integer.parseInt(request.getParameter("user_id"));
				String approver = request.getParameter("approver");
				String state = request.getParameter("state");*/
				String twoapprover = request.getParameter("twoapprover");
				String twostate = request.getParameter("twostate");
				Meetingapply meetingapply = meetingapplyService.load(id);
				meetingapply.setTwoapprover(twoapprover);
				meetingapply.setTwomeetingapply_state(twostate);
				meetingapplyService.update(meetingapply);
				out.println("{\"status\":\"1\"}");

			} else if (oper.equals("searchAjax")) {
				String searchkey = request.getParameter("searchKey");
				if (searchkey != null && !searchkey.equals("")) {
					List<Meetingapply> list = meetingapplyService.listByName(searchkey);
					Gson gson = new Gson();
					Map<String, Object> map = new HashMap();
					map.put("list", list);
					map.put("msg", "success");
					String json = gson.toJson(map);
					out.print(json);
				} else {
					List<Meetingapply> ulist = meetingapplyService.list();
					request.setAttribute("ulist", ulist);
					request.getRequestDispatcher("meetingapplylist.jsp").forward(request, response);
				}
			}
		}
		else {
		List<Meetingapply> ulist = meetingapplyService.list();
		request.setAttribute("ulist", ulist);
		request.getRequestDispatcher("meetingapplylist.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
