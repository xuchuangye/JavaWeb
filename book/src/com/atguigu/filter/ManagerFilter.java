package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ManagerFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//强转类型，获取 Session域对象
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		//获取用户
		Object user = session.getAttribute("user");
		if (user == null) {
			//如果用户没有登录，直接转发到登录页面
			req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
			return;
		} else {
			//如果用户已经登录，默认放行
			chain.doFilter(req,resp);
		}
	}

	@Override
	public void destroy() {

	}
}
