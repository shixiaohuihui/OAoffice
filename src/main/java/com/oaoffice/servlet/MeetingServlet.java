package com.oaoffice.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oaoffice.bean.Meeting;
import com.oaoffice.service.MeetingService;
import com.oaoffice.service.impl.MeetingServiceImpl;
import com.oaoffice.util.Datetransform;

public class MeetingServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4858028295436992783L;

	MeetingService meetingService = new MeetingServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 输出数据乱码解决方案：使用request输出数据前，先设置字符集和内容类型
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		request.setCharacterEncoding("utf-8");

		String oper = request.getParameter("oper");
		PrintWriter out = response.getWriter();
		if (oper != null) {
			if (oper.equals("add")) {
				// 获取表单数据
				String title = request.getParameter("uname");
				Date date = (Date) Datetransform.parse(request.getParameter("date"), "yyyy-MM-dd");
				Date start = (Date) Datetransform.parse(request.getParameter("datestart"), "hh:mm:ss");
				Date end = (Date) Datetransform.parse(request.getParameter("dateend"), "hh:mm:ss");
				String status = request.getParameter("status");
				int roomid = Integer.parseInt(request.getParameter("roomid"));
                System.out.println(start);
				Meeting vMeeting = new Meeting(title, date, start, end, status, roomid);
				meetingService.insert(vMeeting);
				tolist(request, response);
			} else if (oper.equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				meetingService.delete(id);
				tolist(request, response);
			} else if (oper.equals("t_update")) {
				String id = request.getParameter("id");
				System.out.println(id);
				Meeting vMeeting = meetingService.load(Integer.parseInt(id));
				request.setAttribute("vMeeting", vMeeting);
				request.getRequestDispatcher("meetingupdate.jsp").forward(request, response);

			} else if (oper.equals("updateAjax")) {
				System.out.println("update");
				String id = request.getParameter("id");
				String uname = request.getParameter("uname");
				Date date = Datetransform.parse(request.getParameter("date"), "yyyy-MM-dd");
				Date datestart = Datetransform.parse(request.getParameter("datestart"), "hh:mm:ss");
				Date dateend = Datetransform.parse(request.getParameter("dateend"), "hh:mm:ss");
				String status = request.getParameter("status");
				int roomid = Integer.parseInt(request.getParameter("roomid"));

				Meeting vMeeting = new Meeting(uname, date, datestart, dateend, status, roomid);
				vMeeting.setMeeting_id(Integer.parseInt(id));
				meetingService.update(vMeeting);
				out.println("{\"status\":\"1\"}");
			} else if (oper.equals("searchAjax")) {
				System.out.println("search");
				String searchkey = request.getParameter("searchKey");
				System.out.println(searchkey);
				if (searchkey != null && !searchkey.equals("")) {
					List<Meeting> list = meetingService.listByName(searchkey);
					System.out.println(list.get(0).getMeeting_title());
					Gson gson = new Gson();
					Map<String, Object> map = new HashMap();
					map.put("list", list);
					map.put("msg", "success");
					String json = gson.toJson(map);
					out.println(json);
				} else {
					List<Meeting> ulist = meetingService.list();
					request.setAttribute("ulist", ulist);
					request.getRequestDispatcher("meetinglist.jsp").forward(request, response);
				}
			}

		} else {
			tolist(request, response);
		}

	}

	private void tolist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Meeting> ulist = new ArrayList();
		ulist = meetingService.list();
		request.setAttribute("ulist", ulist);
		request.getRequestDispatcher("meetinglist.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
