package com.oaoffice.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oaoffice.bean.Dept;
import com.oaoffice.service.DeptService;
import com.oaoffice.service.impl.DeptServiceImpl;

/**
 * Servlet implementation class DeptServlet
 */
@WebServlet("/DeptServlet")
public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DeptService deptService = new DeptServiceImpl();

	public DeptServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

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

		if (oper != null) {
			if (oper.equals("add")) {
				String dept_name = request.getParameter("deptname");
				String dept_description = request.getParameter("description");
				Dept bean = new Dept(dept_name, dept_description);
				deptService.insert(bean);
				toList(request, response);
			} else if (oper.equals("delete")) {
				// System.out.println("执行删除");
				String id = request.getParameter("id");
				System.out.println(id);
				deptService.delete(Integer.parseInt(id));
				toList(request, response);
			} else if (oper.equals("update1")) {
				String id = request.getParameter("id");
				Dept bean = deptService.load(Integer.parseInt(id));
				request.setAttribute("bean", bean);
				request.getRequestDispatcher("deptupdate.jsp").forward(request, response);
			} else if (oper.equals("update2")) {
				String dept_name = request.getParameter("deptname");
				String dept_description = request.getParameter("description");
				String id = request.getParameter("id");
				Dept bean = new Dept(id, dept_name, dept_description);
				deptService.update(bean);
				toList(request, response);
			} else if (oper.equals("searchAjax")) {
				String searchKey = request.getParameter("searchKey");
				
					List<Dept> list = deptService.listByName(searchKey);
					Gson gson = new Gson();
					String json = gson.toJson(list);
					// System.out.println(json);
					out.print(json);
				
			}
		} else {

			toList(request, response);

		}
	}

	private void toList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Dept> dlist = deptService.list();
		request.setAttribute("dlist", dlist);
		request.getRequestDispatcher("deptlist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
