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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.oaoffice.bean.Dothing;
import com.oaoffice.bean.User;
import com.oaoffice.service.DothingService;
import com.oaoffice.service.UserService;
import com.oaoffice.service.impl.DothingServiceImpl;
import com.oaoffice.service.impl.UserServiceImpl;
import com.oaoffice.util.Datetransform;

public class DothingServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DothingService dothingService = new DothingServiceImpl();
	UserService userService = new UserServiceImpl();
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
				Date end = Datetransform.parse(request.getParameter("end"), "yyyy-MM-dd");
				String priority = request.getParameter("priority");
				String result = request.getParameter("result");
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				Dothing dothing = new Dothing(name, end,priority, result, user_id);
				
				dothingService.insert(dothing);
				out.println("{\"status\":\"1\"}");
				
			}else if (oper.equals("arrange")) {
				/*String Role_name="普通员工";
				HttpSession session = request.getSession();
				session.setAttribute("Role_name", Role_name);*/
				
				List<User> ulist = userService.list();
				request.setAttribute("ulist", ulist);
				request.getRequestDispatcher("dothingarrange.jsp").forward(request, response);
			}else if (oper.equals("delete")) {
				String id = request.getParameter("id");
				System.out.println(id);
				dothingService.delete(Integer.parseInt(id));
				List<Dothing> ulist = dothingService.list();
				request.setAttribute("ulist", ulist);
				request.getRequestDispatcher("dothinglist.jsp").forward(request, response);
			} else if (oper.equals("t_update")) {
				String id = request.getParameter("id");
				System.out.println(id);
				Dothing dothing = dothingService.load(Integer.parseInt(id));
				request.setAttribute("dothing", dothing);
				request.getRequestDispatcher("dothingupdate.jsp").forward(request, response);

			} else if (oper.equals("updateAjax")) {

				String id = request.getParameter("id");
				String name = request.getParameter("name");
				Date end = Datetransform.parse(request.getParameter("end"), "yyyy-MM-dd");
				String priority = request.getParameter("priority");
				String result = request.getParameter("result");
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				Dothing dothing = new Dothing(name, end,priority, result, user_id);
				dothing.setDothing_id(Integer.parseInt(id));
				dothingService.update(dothing);
				out.println("{\"status\":\"1\"}");

			} else if (oper.equals("searchAjax")) {
				System.out.println("qqqqq");
				String searchkey = request.getParameter("searchKey");
				if (searchkey != null && !searchkey.equals("")) {
					List<Dothing> list = dothingService.listByName(searchkey);
					Gson gson = new Gson();
					Map<String, Object> map = new HashMap();
					map.put("list", list);
					map.put("msg", "success");
					String json = gson.toJson(map);
					out.print(json);
				} else {
					List<Dothing> ulist = dothingService.list();
					request.setAttribute("ulist", ulist);
					request.getRequestDispatcher("dothinglist.jsp").forward(request, response);
				}
			}
		}
		else {
		List<Dothing> ulist = dothingService.list();
		request.setAttribute("ulist", ulist);
		request.getRequestDispatcher("dothinglist.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
