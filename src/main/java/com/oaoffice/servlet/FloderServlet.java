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
import com.oaoffice.bean.Floder;
import com.oaoffice.service.FloderService;
import com.oaoffice.service.impl.FloderServiceImpl;
import com.oaoffice.util.Datetransform;

public class FloderServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FloderService floderService = new FloderServiceImpl();

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
				String path = request.getParameter("path");
				int share = Integer.parseInt(request.getParameter("share"));
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				Floder floder = new Floder(name, content,path, share, user_id);
				floderService.insert(floder);
				out.println("{\"status\":\"1\"}");
//				List<Floder> ulist = floderService.list();
//				request.setAttribute("ulist", ulist);
//				request.getRequestDispatcher("floderlist.jsp").forward(request, response);
				
			} else if (oper.equals("delete")) {
				String id = request.getParameter("id");
				System.out.println(id);
				floderService.delete(Integer.parseInt(id));
				show(request, response);
			} else if (oper.equals("t_update")) {
				String id = request.getParameter("id");
				System.out.println(id);
				Floder floder = floderService.load(Integer.parseInt(id));
				request.setAttribute("floder", floder);
				request.getRequestDispatcher("floderupdate.jsp").forward(request, response);

			} else if (oper.equals("updateAjax")) {

				String id = request.getParameter("id");
				String name = request.getParameter("name");
				String content = request.getParameter("content");
				String path = request.getParameter("path");
				int share = Integer.parseInt(request.getParameter("share"));
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				Floder floder = new Floder(name, content,path, share, user_id);
				floder.setFloder_id(Integer.parseInt(id));
				floderService.update(floder);
				out.println("{\"status\":\"1\"}");

			} else if (oper.equals("searchAjax")) {
				System.out.println("qqqqq");
				String searchkey = request.getParameter("searchKey");
				if (searchkey != null && !searchkey.equals("")) {
					List<Floder> list = floderService.listByName(searchkey);
					Gson gson = new Gson();
					Map<String, Object> map = new HashMap();
					map.put("list", list);
					map.put("msg", "success");
					String json = gson.toJson(map);
					out.print(json);
				} else {
					show(request, response);
				}
			}
		}
		else {
		show(request, response);
		}
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Floder> ulist = floderService.list();
		//System.out.println("isshare=" + ulist.get(0).getFloder_isshare());
		/*for(int i=0;i<ulist.size();i++) {
			System.out.println(ulist.get(i).getFloder_isshare());
		}*/
		request.setAttribute("ulist", ulist);
		request.getRequestDispatcher("floderlist.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
