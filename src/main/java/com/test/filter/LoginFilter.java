package com.test.filter;

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

public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String currentUrl = request.getRequestURI();
		String contextPath = request.getContextPath();
		
		String targetUrl = currentUrl.substring(contextPath.length());
		HttpSession session = request.getSession();
		
		if(targetUrl.indexOf("login")>0||targetUrl.indexOf("resources")>0){
			filterChain.doFilter(request, response);
		}else{
			if(session==null||session.getAttribute("currentUser")==null){
				response.sendRedirect(contextPath+"/login");
				return;
			}else{
				filterChain.doFilter(request, response);
				return;
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
