package com.atguigu.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	@Override
	public  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求参数的编码集为UTF-8
		req.setCharacterEncoding("UTF-8");

		//解决浏览器中文乱码的问题
		resp.setContentType("text/html;charset=UTF-8");
		String action = req.getParameter("action");
		try {
			Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);

			method.invoke(this,req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
