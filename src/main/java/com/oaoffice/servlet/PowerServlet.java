package com.oaoffice.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oaoffice.bean.*;
import com.oaoffice.service.PowerService;
import com.oaoffice.service.impl.PowerServiceImpl;

public class PowerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PowerService powerService = new PowerServiceImpl();

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
		if (oper != null && !oper.equals("")) {
			if (oper.equals("update1")) {
				String id = request.getParameter("id");
				User_Role bean = powerService.loadByid(id);
				System.out.println(bean.getUser_id());
				List<Role> role = powerService.listByRole();
				request.setAttribute("bean", bean);
				request.setAttribute("role", role);
				request.getRequestDispatcher("powerupdate.jsp").forward(request, response);
			} else if (oper.equals("update2")) {
				User_Role bean = null;
				String user_id = request.getParameter("userid");
				String role_id = request.getParameter("roleid");
				bean = new User_Role(user_id, role_id);
				powerService.updete(bean);
				toList(request, response);

			} else if (oper.equals("change")) {
				List<Role> role = powerService.listByRole();
				request.setAttribute("role", role);
				request.getRequestDispatcher("rolelist.jsp").forward(request, response);
			} else if (oper.equals("update3")) {
				String id = request.getParameter("id");
				List<Power_Role> list = powerService.listPower_Role(id);
				List<Power_Role> list2 = powerService.listPower();
				request.setAttribute("list", list);
				request.setAttribute("plist", list2);
				request.getRequestDispatcher("roleupdate.jsp").forward(request, response);
			} else if (oper.equals("delete")) {
				String role_id = request.getParameter("role_id");
				String power_id = request.getParameter("power_id");
				powerService.delete(role_id, power_id);
				List<Power_Role> list = powerService.listPower_Role(role_id);
				List<Power_Role> list2 = powerService.listPower();
				request.setAttribute("list", list);
				request.setAttribute("plist", list2);
				request.getRequestDispatcher("roleupdate.jsp").forward(request, response);

			} else if (oper.equals("insertajax")) {
				String role_id = request.getParameter("roleid");
				String power_id = request.getParameter("powerid");
				boolean flag = powerService.insert(role_id, power_id);
				if (flag) {
					out.print("{\"msg\": \"1\"}");
					return;
				} else {
					out.print("{\"msg\": \"2\"}");
					return;
				}

			} else if (oper.equals("searchAjax")) {
				String name = request.getParameter("searchKey");
				List<Power> list = powerService.search(name);
				Gson gson =new  Gson();
				String json = gson.toJson(list);
				out.print(json);
			}
		} else {

			toList(request, response);

		}

	}

	private void toList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Power> list = powerService.list();
		request.setAttribute("plist", list);
		request.getRequestDispatcher("powerlist.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
