package com.atguigu.web;


import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取服务器当中的Session域中保存的数据
		HttpSession session = req.getSession();
		String attribute = (String) session.getAttribute(KAPTCHA_SESSION_KEY);
		//获取之后立即删除Session域中保存的数据
		session.removeAttribute(KAPTCHA_SESSION_KEY);

		if (attribute != null && attribute.equalsIgnoreCase(req.getParameter("code"))) {
			//获取用户名
			String username = req.getParameter("username");
			System.out.println("保存到数据库中： " + username);
			resp.sendRedirect(req.getContextPath() + "/submit.jsp");
		} else {
			System.out.println("请不要重复提交表单");
		}



		//表单重复提交的情况一：用户注册成功进入注册成功的页面之后，一直按F5进行刷新，此时会出现表单重复提交的情况
		//req.getRequestDispatcher("/submit.jsp").forward(req,resp);
		//如何解决表单重复提交的情况一
		//resp.sendRedirect(req.getContextPath() + "/submit.jsp");

		//表单重复提交的情况二：如果服务器有延迟的情况，用户等不及了，多次点击注册按钮，也会出现表单重复提交的情况
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath() + "/submit.jsp");
		*/

		//表单重复提交的情况三：服务器没有延迟，表单正常提交之后，用户回退浏览器，重新提交表单，也会出现表单重复提交的情况
		//resp.sendRedirect(req.getContextPath() + "/submit.jsp");
	}
}
