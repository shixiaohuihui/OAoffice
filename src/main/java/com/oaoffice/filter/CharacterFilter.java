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

public class CharacterFilter implements Filter {
	private String encoding = null;;

	
	public void destroy() {
		// TODO Auto-generated method stub
		encoding = null;
	}

	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// FilterChain 过滤器链
		System.out.println("CharacterFilter call Filter");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		if (encoding != null) {
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset=" + encoding);
		}
		/*
		 * 在过滤器对象的doFilter()方法中，业务逻辑处理完成之后，
		 * 需要通过FilterChain对象的doFilter()方法将请求传递到下一过滤器或目标资源，否则将出现错误。
		 */
		chain.doFilter(req, resp);
	}

	
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding = filterConfig.getInitParameter("encoding");
	}
}
