package com.atguigu.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends BaseServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//2.创建
		if ("wzg168".equals(username) && "123456".equals(password)) {
			Cookie cookie = new Cookie("username",username);
			cookie.setMaxAge(60 * 60 * 24 * 7);//一周之内有效
			resp.addCookie(cookie);
			resp.getWriter().write("登录成功");
		} else {
			resp.getWriter().write("登录失败");
		}
	}
}
