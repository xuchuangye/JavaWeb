package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
	public AdminFilter(){
		super();
		System.out.println("1.Filter过滤器的AdminFilter构造方法");
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("2.Filter过滤器的Init初始化方法");
		//获取Filter的名称filter-name
		System.out.println("获取Filter过滤器的filter-name: " + filterConfig.getFilterName());
		//获取web.xml文件中配置init-param标签当中初始化的参数
		System.out.println("获取web.xml配置init-param的初始化参数username的值： " + filterConfig.getInitParameter("username"));
		System.out.println("获取web.xml配置init-param的初始化参数url的值： " + filterConfig.getInitParameter("url"));
		//获取ServletContext对象
		System.out.println("获取ServletContext对象： " + filterConfig.getServletContext());

	}

	/**
	 * Filter过滤器当中主要用于拦截请求的方法
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("3.Filter过滤器的doFilter过滤方法");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession();

		Object user = session.getAttribute("user");
		//判断用户是否登录，如果用户没有登录跳转到登录页面，如果用户登录则默认其行为
		if (user == null) {
			httpServletRequest.getRequestDispatcher("/login.jsp").forward(request,response);
			return;
		} else {
			//让程序继续往下访问用户的目标资源
			chain.doFilter(request,response);
		}
	}

	@Override
	public void destroy() {
		System.out.println("4.Filter过滤器的destroy方法");
	}
}
