package com.atguigu.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {

	//获取Session的默认超时时长
	protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取Session会话对象
		HttpSession session = req.getSession();
		//获取超时时长
		int maxInactiveInterval = session.getMaxInactiveInterval();
		resp.getWriter().write("Session默认的超时时长为" + maxInactiveInterval + "秒");
	}

	//设置当前Session的超时时长为5秒，5秒之后立即销毁
	protected void fiveSecondsLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取Session会话对象
		HttpSession session = req.getSession();
		//设置当前Session的超时时长为5秒，单位为秒
		session.setMaxInactiveInterval(5);
		//打印提示信息
		resp.getWriter().write("当前Session的超时时长已经被修改为5秒");
	}

	//设置当前Session会话对象立即销毁
	protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取当前Session会话对象
		HttpSession session = req.getSession();
		//设置Session会话对象的超时时长为立即销毁
		session.invalidate();
		//打印提示信息
		resp.getWriter().write("当前Session已经被立即销毁了(Session已经无效)");
	}

	//在Session域中存储数据
	protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//存储数据到Session域中
		HttpSession session = req.getSession();
		session.setAttribute("key1","value1");

		//打印提示信息
		resp.getWriter().write("已经往Session域中存储数据了");
	}

	//获取存储在Session域中的数据
	protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取Session域中的数据
		HttpSession session = req.getSession();
		//key键一定要与需要获取的Session的key一一对应
		Object attribute = session.getAttribute("key1");

		//打印提示信息
		resp.getWriter().write("获取存储在Session域中的key1的值是： " + attribute);
	}

	//创建和获取Session会话对象
	protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//创建和获取Session会话对象，第一次调用该方法是创建Session会话对象
		HttpSession session = req.getSession();
		//isNew判断当前Session的会话对象是否是新创建出来的
		boolean isNew = session.isNew();
		//获取Session会话对象的唯一ID值，也就是唯一标识
		String id = session.getId();

		resp.getWriter().write("创建当前的Session会话对象的唯一ID值为： " + id + "<br/>");
		resp.getWriter().write("当前的Session会话对象是否是新创建的： " + isNew + "<br/>");
	}
}
