package com.oaoffice.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oaoffice.bean.MeetingRoom;
import com.oaoffice.service.MeetingRoomService;
import com.oaoffice.service.impl.MeetingRoomServiceImpl;

public class MeetingRoomServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4858028295436992783L;

	MeetingRoomService meetingRoomService = new MeetingRoomServiceImpl();

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
				String roomname = request.getParameter("roomname");
				String usercount = request.getParameter("usercount");

				MeetingRoom vMeetingRoom = new MeetingRoom(roomname, usercount);
				meetingRoomService.insert(vMeetingRoom);
				
				List<MeetingRoom> ulist = new ArrayList();
				ulist = meetingRoomService.list();
				request.setAttribute("ulist", ulist);
				request.getRequestDispatcher("meetingroomlist.jsp").forward(request, response);
				
			} else if (oper.equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				meetingRoomService.delete(id);
			} else if (oper.equals("t_update")) {
				String id = request.getParameter("id");
				System.out.println(id);
				MeetingRoom vMeetingRoom = meetingRoomService.load(Integer.parseInt(id));
				request.setAttribute("vMeetingRoom", vMeetingRoom);
				request.getRequestDispatcher("meetingroomupdate.jsp").forward(request, response);

			} else if (oper.equals("updateAjax")) {
				System.out.println("update");
				String roomname = request.getParameter("roomname");
				String usercount = request.getParameter("usercount");

				String roomid = request.getParameter("id");
				MeetingRoom vMeetingRoom = new MeetingRoom(roomname, usercount);
				vMeetingRoom.setMeetingroom_id(Integer.parseInt(roomid));
				meetingRoomService.update(vMeetingRoom);
				out.println("{\"status\":\"1\"}");
			} else if (oper.equals("searchAjax")) {
				System.out.println("search");
				String searchkey = request.getParameter("searchKey");
				System.out.println(searchkey);
				if (searchkey != null && !searchkey.equals("")) {
					List<MeetingRoom> list = meetingRoomService.listByName(searchkey);
					Gson gson = new Gson();
					Map<String, Object> map = new HashMap();
					map.put("list", list);
					map.put("msg", "success");
					String json = gson.toJson(map);
					out.println(json);
				} else {
					List<MeetingRoom> ulist = meetingRoomService.list();
					request.setAttribute("ulist", ulist);
					request.getRequestDispatcher("meetingroomlist.jsp").forward(request, response);
				}
			}

		} else {
			List<MeetingRoom> ulist = new ArrayList();
			ulist = meetingRoomService.list();
			request.setAttribute("ulist", ulist);
			request.getRequestDispatcher("meetingroomlist.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
