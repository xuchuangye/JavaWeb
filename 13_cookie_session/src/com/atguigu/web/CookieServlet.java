package com.atguigu.web;

import com.atguigu.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {
	//设置path属性
	protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = new Cookie("path1", "path1");
		cookie.setPath(req.getContextPath() + "/abc");
		resp.addCookie(cookie);
	}

	//设置和检验Cookie的存活时间，参数为3600秒，表示存活3600秒
	protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = new Cookie("life3600", "life3600");
		cookie.setMaxAge(60 * 60);//参数3600秒，存活一小时
		resp.addCookie(cookie);
	}

	//设置和检验Cookie的存活时间，参数为0，表示立即删除Cookie
	protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		//找到需要删除的cookie对象
		Cookie cookie = CookieUtils.findCookie("key2", cookies);
		//调用setMaxAge(0)
		if (cookie != null) {
			cookie.setMaxAge(0);
		}

		//必须添加这个语句，否则不会生效
		resp.addCookie(cookie);

		resp.getWriter().write("key2已经被删除了");
	}
	//设置和检验Cookie的存活时间，默认值-1，表示关闭浏览器之后，Cookie就会销毁
	protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = new Cookie("defaultLife", "defaultLife");
		//设置存活时间
		cookie.setMaxAge(-1);//-1表示关闭浏览器，就会销毁cookie
		resp.addCookie(cookie);

	}
	//服务器响应客户端查找同key名的Cookie并修改
	protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//方式一
		//1.直接创建一个同key名的Cookie对象
		//2.通过构造器修改Cookie的value值
		//Cookie cookie = new Cookie("key1", "newValue1");
		//3.服务器响应给客户端保存并修改
		//resp.addCookie(cookie);
		//resp.getWriter().write("cookie已经被修改了");

		//方式二
		//1.先获取cookie数组中需要修改的key的cookie对象
		Cookie[] cookies = req.getCookies();
		//2.通过cookie对象.seValue()修改
		Cookie key2 = CookieUtils.findCookie("key2", cookies);
		if (key2 != null) {
			key2.setValue("newValue2");
			//3.服务器响应给客户端保存并修改
			resp.addCookie(key2);
		}
		resp.getWriter().write("cookie已经被修改了");
	}

	//服务器获取客户端请求的Cookie
	protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//客户端的请求，服务器使用req.getCookies()获取全部的Cookie
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			resp.getWriter().write("Cookie[ " + cookie.getName() + " = " + cookie.getValue() + " ] <br/>" );
		}
		//服务器获取单个客户端请求过来的Cookie对象
		if (CookieUtils.findCookie("key2",cookies) != null) {
			resp.getWriter().write("找到了key为'key2'的Cookie");
		}
	}
	//服务器创建Cookie并响应客户端保存Cookie
	protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.创建Cookie对象
		Cookie cookie = new Cookie("key1", "value1");
		Cookie cookie1 = new Cookie("key2", "value2");
		//2.通知客户端浏览器保存Cookie，服务器响应给客户端浏览器
		resp.addCookie(cookie);
		resp.addCookie(cookie1);
		//3.写到页面上
		resp.getWriter().write("Cookie创建成功");
	}
}
