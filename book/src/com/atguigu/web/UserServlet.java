package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.CookieUtils;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class UserServlet extends BaseServlet {

	private UserService userService = new UserServiceImpl();

	/**
	 * 处理登录的功能
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.接收用户传递的参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//2.处理业务逻辑
		User loginUser = userService.login(new User(null, username, password, null));
		//3.根据结果判断用户名和密码是否输入正确，从而是否登录成功或者失败
		if (loginUser == null) {
			//把错误信息和回显的表单项信息，保存到request域中
			req.setAttribute("msg", "用户名或者密码输入错误！！！");
			req.setAttribute("username", username);
			//跳转到登录页面
			req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
		} else {
			//用户名和密码输入正确，登录成功
			//将用户信息保存到Session域中
			HttpSession session = req.getSession();
			session.setAttribute("user",loginUser);
			//跳转到登录成功页面login_success.html
			req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
		}
	}

	/**
	 * 处理注册的功能
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.接收用户传递的参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String code = req.getParameter("code");


		//将两行合并成一行
		/*
		User user = new User();
		WebUtils.copyParamToBean(user, req.getParameterMap());
		*/
		User user = WebUtils.copyParamToBean(new User(), req.getParameterMap());


		if ("abcde".equalsIgnoreCase(code)) {
			//正确
			//3、检查用户名是否可用
			if (userService.existsUsername(username)) {
				//用户名已存在
				//将错误的信息和用户名和邮箱保存到域中
				req.setAttribute("msg", "用户名已存在！！！");
				req.setAttribute("username", username);
				req.setAttribute("email", email);
				//跳回注册页面
				req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
			} else {
				//用户名可用
				//调用Service保存到数据库
				userService.registerUser(new User(null, username, password, email));
				//跳到注册成功束面regist_success.html
				req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
			}
		} else {
			//不正确
			//将错误的信息和用户名和邮箱保存到域中
			req.setAttribute("msg", "验证码输入不正确！！！");
			req.setAttribute("username", username);
			req.setAttribute("email", email);
			//跳回注册页面
			req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
		}
	}

	/**
	 * 注销用户的功能
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取当前的Session会话对象
		HttpSession session = req.getSession();
		//设置Session立即失效和销毁
		session.invalidate();
		//请求重定向
		resp.sendRedirect(req.getContextPath());
	}

	/**
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求的参数
		String username = req.getParameter("username");
		//调用UserService.existsUsername
		boolean existsUsername = userService.existsUsername(username);
		//把返回的结果封装成Map对象返回给客户端
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("existsUsername",existsUsername);

		Gson gson = new Gson();
		//将map集合转换成json字符串
		String mapJsonString = gson.toJson(map);
		resp.getWriter().write(mapJsonString);
	}
}
