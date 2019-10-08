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
import com.oaoffice.bean.Bulletin;
import com.oaoffice.service.BulletinService;
import com.oaoffice.service.impl.BulletinServiceImpl;
import com.oaoffice.util.Datetransform;

public class BulletinServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BulletinService bulletinService = new BulletinServiceImpl();

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
				String content = request.getParameter("content");
				Date start = Datetransform.parse(request.getParameter("start"), "yyyy-MM-dd");
				String realname = request.getParameter("realname");
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				Bulletin bulletin = new Bulletin(name,content, start,realname,user_id);
				bulletinService.insert(bulletin);
				List<Bulletin> ulist = bulletinService.list();
				request.setAttribute("ulist", ulist);
				request.getRequestDispatcher("bulletinlist.jsp").forward(request, response);
				
			}else if (oper.equals("t_add")) {
				request.getRequestDispatcher("bulletininsert.jsp").forward(request, response);
            } else if (oper.equals("delete")) {
				String id = request.getParameter("id");
				System.out.println(id);
				bulletinService.delete(Integer.parseInt(id));
				List<Bulletin> ulist = bulletinService.list();
				request.setAttribute("ulist", ulist);
				request.getRequestDispatcher("bulletinlist.jsp").forward(request, response);
			} else if (oper.equals("t_update")) {
				String id = request.getParameter("id");
				System.out.println(id);
				Bulletin bulletin = bulletinService.load(Integer.parseInt(id));
				request.setAttribute("bulletin", bulletin);
				request.getRequestDispatcher("bulletinupdate.jsp").forward(request, response);

			} else if (oper.equals("updateAjax")) {

				String id = request.getParameter("id");
				String name = request.getParameter("name");
				String content = request.getParameter("content");
				Date start = Datetransform.parse(request.getParameter("start"), "yyyy-MM-dd");
				String realname = request.getParameter("realname");
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				Bulletin bulletin = new Bulletin(name,content, start,realname , user_id);
				bulletin.setBulletin_id(Integer.parseInt(id));
				bulletinService.update(bulletin);
				out.println("{\"status\":\"1\"}");

			} else if (oper.equals("searchAjax")) {
				String searchkey = request.getParameter("searchKey");
				if (searchkey != null && !searchkey.equals("")) {
					List<Bulletin> list = bulletinService.listByName(searchkey);
					Gson gson = new Gson();
					Map<String, Object> map = new HashMap();
					map.put("list", list);
					map.put("msg", "success");
					String json = gson.toJson(map);
					out.print(json);
				} else {
					List<Bulletin> ulist = bulletinService.list();
					request.setAttribute("ulist", ulist);
					request.getRequestDispatcher("bulletinlist.jsp").forward(request, response);
				}
			}
		}
		else {
		List<Bulletin> ulist = bulletinService.list();
		String msg = ulist.get(ulist.size()-1).getBulletin_content();
		request.setAttribute("msg", msg);
		request.setAttribute("ulist", ulist);
		request.getRequestDispatcher("bulletinlist.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
