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

import com.oaoffice.service.PowerService;
import com.oaoffice.service.impl.PowerServiceImpl;
import com.google.gson.Gson;
import com.oaoffice.bean.Power;
import com.oaoffice.bean.User;
import com.oaoffice.service.UserService;
import com.oaoffice.service.impl.UserServiceImpl;
import com.oaoffice.util.Datetransform;
import com.oaoffice.util.PagingVO;

public class UserListServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		
		if (oper != null) {
			if (oper.equals("searchAjax")) {
				System.out.println("qqqqq");
				String searchkey = request.getParameter("searchKey");
				if (searchkey != null && !searchkey.equals("")) {
					List<User> list = userService.listByName(searchkey);
					Gson gson = new Gson();
					Map<String, Object> map = new HashMap();
					map.put("list", list);
					map.put("msg", "success");
					String json = gson.toJson(map);
					// System.out.println(json);
					out.print(json);
				} else {
					List<User> list =userService.list();
					request.setAttribute("ulist", list);
					request.getRequestDispatcher("addressbook.jsp").forward(request, response);
				}
			}
		}
		List<User> list =userService.list();
		request.setAttribute("ulist", list);
		request.getRequestDispatcher("addressbook.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
