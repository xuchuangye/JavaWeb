package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
	//因为web层不能直接调用Dao层，所以使用Service层调用Dao层
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取Session域中保存的验证码数据
		HttpSession session = req.getSession();
		String attribute = (String) session.getAttribute(KAPTCHA_SESSION_KEY);
		//获取Session域中的数据之后，立即删除验证码数据
		session.removeAttribute(KAPTCHA_SESSION_KEY);

		//1、获取请求的参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String code = req.getParameter("code");

		//2、检查验证码是否正确
		if (attribute != null && attribute.equalsIgnoreCase(code)) {
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
				System.out.println("用户名可用！");
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
}
