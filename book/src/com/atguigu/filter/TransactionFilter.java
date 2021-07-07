package com.atguigu.filter;

import com.atguigu.utils.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


		try {
			chain.doFilter(request,response);
			//提交事务
			JDBCUtils.commitAndClose();
		} catch (Exception e) {
			//回滚事务
			JDBCUtils.rollBackAndClose();
			e.printStackTrace();
			//将异常抛出发送给Tomcat服务器进行接收
			throw new RuntimeException(e);
		}

	}

	@Override
	public void destroy() {

	}
}
