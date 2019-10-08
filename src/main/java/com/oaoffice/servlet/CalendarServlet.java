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
import com.oaoffice.bean.Calendar;
import com.oaoffice.service.CalendarService;
import com.oaoffice.service.impl.CalendarServiceImpl;
import com.oaoffice.util.Datetransform;

public class CalendarServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CalendarService calendarService = new CalendarServiceImpl();

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
				String name = request.getParameter("name");
				Date start = Datetransform.parse(request.getParameter("start"), "yyyy-MM-dd");
				Date end = Datetransform.parse(request.getParameter("end"), "yyyy-MM-dd");
				String remind = request.getParameter("remind");
				String content = request.getParameter("content");
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				Calendar calendar = new Calendar(name, start, end, remind, content, user_id);
				calendarService.insert(calendar);
				out.println("{\"status\":\"1\"}");
				
			} else if (oper.equals("delete")) {
				String id = request.getParameter("id");
				System.out.println(id);
				calendarService.delete(Integer.parseInt(id));
				List<Calendar> ulist = calendarService.list();
				request.setAttribute("ulist", ulist);
				request.getRequestDispatcher("calendarlist.jsp").forward(request, response);
			} else if (oper.equals("t_update")) {
				String id = request.getParameter("id");
				System.out.println(id);
				Calendar calendar = calendarService.load(Integer.parseInt(id));
				request.setAttribute("calendar", calendar);
				request.getRequestDispatcher("calendarupdate.jsp").forward(request, response);

			} else if (oper.equals("updateAjax")) {

				String id = request.getParameter("id");
				String name = request.getParameter("name");
				Date start = Datetransform.parse(request.getParameter("start"), "yyyy-MM-dd");
				Date end = Datetransform.parse(request.getParameter("end"), "yyyy-MM-dd");
				String remind = request.getParameter("remind");
				String content = request.getParameter("content");
				System.out.println("www"+id);
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				Calendar calendar = new Calendar(name, start, end, remind, content, user_id);
				calendar.setCalendar_id(Integer.parseInt(id));
				calendarService.update(calendar);
				out.println("{\"status\":\"1\"}");

			} else if (oper.equals("searchAjax")) {
				System.out.println("qqqqq");
				String searchkey = request.getParameter("searchKey");
				if (searchkey != null && !searchkey.equals("")) {
					List<Calendar> list = calendarService.listByName(searchkey);
					Gson gson = new Gson();
					Map<String, Object> map = new HashMap();
					map.put("list", list);
					map.put("msg", "success");
					String json = gson.toJson(map);
					out.print(json);
				} else {
					List<Calendar> ulist = calendarService.list();
					request.setAttribute("ulist", ulist);
					request.getRequestDispatcher("calendarlist.jsp").forward(request, response);
				}
			}
		}
		else {
		List<Calendar> ulist = calendarService.list();
		request.setAttribute("ulist", ulist);
		request.getRequestDispatcher("calendarlist.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
