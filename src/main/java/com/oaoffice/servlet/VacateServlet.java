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
import com.oaoffice.bean.Vacate;
import com.oaoffice.service.VacateService;
import com.oaoffice.service.impl.VacateServiceImpl;
import com.oaoffice.util.Datetransform;

public class VacateServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	VacateService vacateService = new VacateServiceImpl();
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
				Date start = Datetransform.parse(request.getParameter("start"), "yyyy-MM-dd");
				String time = request.getParameter("time");
				String reason = request.getParameter("reason");
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				String approver =" ";
				String state = " ";
				Vacate vacate = new Vacate(start,time,reason,user_id,approver,state);
				vacateService.insert(vacate);
				out.println("{\"status\":\"1\"}");
				//List<Vacate> ulist = vacateService.list();
				//request.setAttribute("ulist", ulist);
				//request.getRequestDispatcher("vacatelist.jsp").forward(request, response);
				
			} else if (oper.equals("delete")) {
				String id = request.getParameter("id");
				System.out.println(id);
				vacateService.delete(Integer.parseInt(id));
				List<Vacate> ulist = vacateService.list();
				request.setAttribute("ulist", ulist);
				request.getRequestDispatcher("vacatelist.jsp").forward(request, response);
			} else if (oper.equals("t_update")) {
				String id = request.getParameter("id");
				System.out.println(id);
				Vacate vacate = vacateService.load(Integer.parseInt(id));
				request.setAttribute("vacate", vacate);
				request.getRequestDispatcher("vacateupdate.jsp").forward(request, response);

			} else if (oper.equals("updateAjax")) {

				String id = request.getParameter("id");
				Date start = Datetransform.parse(request.getParameter("start"), "yyyy-MM-dd");
				String time = request.getParameter("time");
				String reason = request.getParameter("reason");
				int user_id= Integer.parseInt(request.getParameter("user_id"));
				String approver = request.getParameter("approver");
				String state = request.getParameter("state");
				Vacate vacate = new Vacate(start,time,reason,user_id,approver,state);
				vacate.setVacate_id(Integer.parseInt(id));
				vacateService.update(vacate);
				out.println("{\"status\":\"1\"}");

			} else if (oper.equals("searchAjax")) {
				String searchkey = request.getParameter("searchKey");
				if (searchkey != null && !searchkey.equals("")) {
					List<Vacate> list = vacateService.listByName(searchkey);
					Gson gson = new Gson();
					Map<String, Object> map = new HashMap();
					map.put("list", list);
					map.put("msg", "success");
					String json = gson.toJson(map);
					out.print(json);
				} else {
					List<Vacate> ulist = vacateService.list();
					request.setAttribute("ulist", ulist);
					request.getRequestDispatcher("vacatelist.jsp").forward(request, response);
				}
			}
		}
		else {
		List<Vacate> ulist = vacateService.list();
		request.setAttribute("ulist", ulist);
		request.getRequestDispatcher("vacatelist.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
