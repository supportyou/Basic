package com.basic.filter;


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

import com.basic.pojo.User;

/**
 * 编写Servlet中的过滤器
 * @author Administrator
 */
public class SecurityFilter implements Filter {
	@Override
	public void destroy() {
	}

	//过滤功能
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		HttpSession session = request.getSession();
		//从Session中取名为“curr_mgr”的对象。
		User user = (User)session.getAttribute("user");
		//登录后的用户，会在Session中以“curr_mgr”为存放当前用户的Manager对象。
		if(user != null){
			chain.doFilter(request, response); //请求通过
		}else{
			//跳转到登录页面，并提示信息
			session.setAttribute("msg", "请先登录！");
			//请求分派，重定向
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
