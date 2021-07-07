package com.atguigu.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//浏览器中文乱码的问题
		resp.setContentType("text/html;charset=UTF-8");
		//获取用户名和密码
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//获取域对象Session
		HttpSession session = req.getSession();
		//比较用户名和密码
		if ("admin".equalsIgnoreCase(username) && "admin".equalsIgnoreCase(password)) {
			session.setAttribute("user",username);
			resp.getWriter().write("登录成功！！！");
		} else {
			req.getRequestDispatcher("/login.jsp").forward(req,resp);
		}
	}
}
