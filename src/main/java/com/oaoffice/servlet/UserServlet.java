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

public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();
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
		String curentPageNo = request.getParameter("curentPageNo");
		if (oper != null) {
			if (oper.equals("add")) {
				// 获取表单数据
				String uname = request.getParameter("uname");
				String realname = request.getParameter("realname");
				String pwd = request.getParameter("pwd");
				String gender = request.getParameter("gender");
				String phonenumber = request.getParameter("phonenumber");
				Date born = Datetransform.parse(request.getParameter("born"), "yyyy-MM-dd");

				String province = request.getParameter("province");
				String city = request.getParameter("city");
				String area = request.getParameter("area");
				String address = province + city + area;
				String email = request.getParameter("email");
				String headpic = request.getParameter("headpic");
				int dept_id = Integer.parseInt(request.getParameter("dept_id"));
				User user = new User(uname, realname, pwd, gender, phonenumber, born, address, email, headpic, dept_id);
				userService.insert(user);
				out.println("{\"status\":\"1\"}");
			} else if (oper.equals("checkAjax")) {
				String uname = request.getParameter("uname");
				System.out.println(uname + 555555555);
				boolean flag = userService.checkUser(uname);
				if (flag) {
					out.println("{\"isCheck\":\"1\"}");
				} else {
					out.println("{\"isCheck\":\"0\"}");
				}

			} else if (oper.equals("delete")) {
				String id = request.getParameter("id");
				System.out.println(id);
				userService.delete(Integer.parseInt(id));
				show(request, response, curentPageNo);
			} else if (oper.equals("t_update")) {
				String id = request.getParameter("id");
				System.out.println(id);
				User user = userService.load(Integer.parseInt(id));
				request.setAttribute("user", user);
				request.getRequestDispatcher("userupdate.jsp").forward(request, response);

			} else if (oper.equals("updateAjax")) {
				String id = request.getParameter("id");
				String uname = request.getParameter("uname");
				String realname = request.getParameter("realname");
				String pwd = request.getParameter("pwd");
				String gender = request.getParameter("gender");
				String phonenumber = request.getParameter("phonenumber");
				Date born = Datetransform.parse(request.getParameter("born"), "yyyy-MM-dd");

				String province = request.getParameter("province");
				String city = request.getParameter("city");
				String area = request.getParameter("area");
				String address = province + " " + city + " " + area;
				String hobby = request.getParameter("hobby");
				String email = request.getParameter("email");
				String headpic = request.getParameter("headpic");
				String selfassessment = request.getParameter("selfassessment");
				int dept_id = Integer.parseInt(request.getParameter("dept_id"));
				User user = new User(uname, realname, pwd, gender, phonenumber, born, address, hobby, email,selfassessment, headpic,
						dept_id);
				user.setUser_id(Integer.parseInt(id));
				userService.update(user);
				out.println("{\"status\":\"1\"}");
			} else if (oper.equals("userinfo")) {
				// String id = request.getParameter("id");
				String uname = request.getParameter("uname");
				String realname = request.getParameter("realname");
				String gender = request.getParameter("gender");
				String phonenumber = request.getParameter("phonenumber");
				Date born = Datetransform.parse(request.getParameter("born"), "yyyy-MM-dd");
				String province = request.getParameter("province");
				String city = request.getParameter("city");
				String area = request.getParameter("area");
				String address = province + " " + city + " " + area;
				String[] hobby = request.getParameterValues("hobby");
				StringBuffer hobby2 = new StringBuffer();
				if (hobby != null) {
					for (String string : hobby) {
						hobby2.append(string + " ");
					}
				}
				String email = request.getParameter("email");
				String selfassessment = request.getParameter("selfassessment");
				String headpic = request.getParameter("headpic");

				User user = userService.loadByNo(uname);
				user.setUser_realname(realname);
				user.setUser_sex(gender);
				user.setPhonenumber(phonenumber);
				user.setUser_born(born);
				user.setUser_address(address);
				user.setUser_hobby(hobby2.toString());
				user.setUser_email(email);
				user.setSelfassessment(selfassessment);
				user.setHeadpic(headpic);
				userService.update(user);
				out.println("{\"status\":\"1\"}");
			} else if (oper.equals("t_userinfo")) {

				request.getRequestDispatcher("userInfo.jsp").forward(request, response);
			} else if (oper.equals("searchAjax")) {
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
					show(request, response, curentPageNo);
				}
			} else if (oper.equals("loginAjax")) {
				String logname = request.getParameter("logname");
				String logpass = request.getParameter("logpass");
				User bean = userService.loadByNo(logname);
				// System.out.println(bean.getUser_id() + "qweasdzxc");
				if (bean != null) {
					boolean flag = bean.getUser_name().equals(logname) && bean.getUser_pwd().equals(logpass);
					if (flag) {
						// 把请求域范围扩大到会话范围session
						// 获取session对象
						HttpSession session = request.getSession();
						session.setAttribute("loginUser", bean.getUser_realname());
						session.setAttribute("loginUser_name", bean.getUser_name());
						session.setAttribute("loginUser_id", bean.getUser_id());
						session.setAttribute("loginUser_pwd", bean.getUser_pwd());
						session.setAttribute("loginUser_sex", bean.getUser_sex());
						session.setAttribute("loginPhonenumber", bean.getPhonenumber());
						session.setAttribute("loginUser_born", bean.getUser_born());
						String[] address = null;
						if (bean.getUser_address() != null) {
							address = bean.getUser_address().split("\\s+");
						}
						session.setAttribute("loginUser_address", address);
						String[] hobby = null;
						if (bean.getUser_hobby() != null) {
							hobby = bean.getUser_hobby().split("\\s+");
						}
						session.setAttribute("loginUser_hobby", hobby);
						session.setAttribute("loginUser_email", bean.getUser_email());
						session.setAttribute("loginSelfassessment", bean.getSelfassessment());
						session.setAttribute("loginHeadpic", bean.getHeadpic());

						System.out.println("bean.getHeadpic=" + bean.getHeadpic());
						System.out.println("loginSelfassessment=" + bean.getSelfassessment());

						List<Power> allpowerlist = powerService.list1();

						session.setAttribute("allpowerlist", allpowerlist);

						// 获取权限信息
						List<Power> powerlist = powerService.getPower(logname);
						// System.out.println("Role_id=" + powerlist.get(0).getRole_id());
						session.setAttribute("role_id", powerlist.get(0).getRole_id());
						session.setAttribute("powerlist", powerlist);
						out.println("{\"status\":\"1\"}");
					} else {
						out.print("{\"status\":\"0\",\"msg\":\"login fail\"}");
					}
				}
			} else if (oper.equals("logout")) {
				HttpSession session = request.getSession();
				session.removeAttribute("loginUser");
				session.removeAttribute("loginUser_name");
				session.removeAttribute("loginUser_id");
				session.removeAttribute("powerlist");
				session.invalidate();
				response.sendRedirect("login.jsp");
			} else if (oper.equals("changePwdAjax")) {
				String id = request.getParameter("id");
				String name = request.getParameter("name");
				System.out.println("bbbb" + id);
				String pwd = request.getParameter("pwd");
				User user = userService.loadByNo(name);
				user.setUser_pwd(pwd);
				userService.update(user);
				out.println("{\"status\":\"1\"}");
			} else if (oper.equals("loginout")) {
				HttpSession session = request.getSession();
				session.removeAttribute("loginUser_name");
				session.removeAttribute("loginUser_pwd");
				session.invalidate();
				response.sendRedirect("login.jsp");
			}
		} else {
			show(request, response, curentPageNo);
		}
	}

	private void show(HttpServletRequest request, HttpServletResponse response, String curentPageNo)
			throws ServletException, IOException {
		// 登录成功
		List<User> list = null;
		// 查询数据库总记录数
		int total = userService.count();
		// 实例化分页对象
		PagingVO page = new PagingVO();
		page.setPageSize(5);
		page.setTotalCount(total);
		System.out.println(curentPageNo + "444444444");
		if (curentPageNo != null && !curentPageNo.equals("")) {
			if (curentPageNo.equals("0")) {
				page.setCurentPageNo(1);
			} else if (curentPageNo.equals(String.valueOf(page.getTotalCount() + 1))) {
				page.setCurentPageNo(page.getTotalCount());
			} else {
				page.setCurentPageNo(Integer.parseInt(curentPageNo));
			}

		}

		// 查询列表
		list = userService.queryAll(page);
		request.setAttribute("page", page);

		/*
		 * HttpSession session = request.getSession(); List<Power> powerlist1
		 * =powerService.list(); session.setAttribute("powerlist1", powerlist1);
		 * System.out.println(powerlist1.size());
		 */

		request.setAttribute("ulist", list);
		request.getRequestDispatcher("userlist.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
