package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求体的参数（检查的材料）
        System.out.println("柜台2获取请求体的参数：" + req.getParameter("username"));
        //2.检查有没有柜台1的章
        System.out.println("检查柜台1有没有盖章： " + req.getAttribute("key"));
        //3.处理自己的业务
        System.out.println("柜台2处理自己的业务");
    }
}
