package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收用户传递的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.处理业务逻辑
        User user = userService.login(new User(null, username, password, null));
        //3.根据结果判断用户名和密码是否输入正确，从而是否登录成功或者失败
        if (user == null ) {
            //把错误信息和回显的表单项信息，保存到request域中
            req.setAttribute("msg","用户名或者密码输入错误！！！");
            req.setAttribute("username",username);
            //跳转到登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else {
            //用户名和密码输入正确，登录成功
            //跳转到登录成功页面login_success.html
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }

    }
}
