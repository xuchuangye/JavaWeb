package com.atguigu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.有没有带请求参数（检查材料）
        System.out.println("是否带了请求参数（检查的材料）：" +  req.getParameter("username"));
        //2.处理完业务，盖一个章
        req.setAttribute("key","柜台1的章");
        //3.问路，柜台2怎么走
        //RequestDispatcher request = req.getRequestDispatcher("/servlet2");
        //甚至可以通过请求转发访问浏览器保护的WEB-INF当中的文件
        RequestDispatcher request = req.getRequestDispatcher("/WEB-INF/form.html");
        //4.走到柜台2
        request.forward(req, resp);
    }
}
