package com.oaoffice.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginFilter implements Filter {

	private String encoding = null;;

	
	public void destroy() {
		// TODO Auto-generated method stub
		encoding = null;
	}

	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// FilterChain 过滤器链
		System.out.println("call Filter");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		if (encoding != null) {
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset=" + encoding);
		}
		HttpSession session = request.getSession();

		String uri=request.getRequestURI();
		String oper=request.getParameter("oper");
		System.out.println("uri="+uri);
		
		if(uri.contains("login.jsp") || uri.contains(".jpg")|| uri.contains(".png") || uri.contains(".css") || uri.endsWith(".js")) {
				//	不过滤
			System.out.println("1");
		}
		else if(uri.contains("UserServlet.do") && oper!=null && oper.contains("login")) {
				//	不过滤
			System.out.println("2");
		}
		else {
			System.out.println("3");
			if(session.getAttribute("loginUser")==null){
				System.out.println("4");
				System.out.println("filter uri="+uri);
				System.out.println("oper="+oper);
				session.removeAttribute("loginUser");
				response.sendRedirect("login.jsp");
				return;
			}
		}
		chain.doFilter(req, resp);
	}

	
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding = filterConfig.getInitParameter("encoding");
	}

}
