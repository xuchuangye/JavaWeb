package com.atguigu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext对象实例
        ServletContext servletContext = getServletConfig().getServletContext();
        //1,获取上下文参数的参数值
        System.out.println("context-param参数username的参数值是：" + servletContext.getInitParameter("username"));//root
        System.out.println("context-param参数password的参数值是：" + servletContext.getInitParameter("password"));//691020

        //2.获取当前工程路径，格式：/工程路径
        System.out.println("当前的工程路径：" + servletContext.getContextPath());///07_servlet

        //3.获取工程部署之后在服务器硬盘上的绝对路径
        /*
        * /斜杠被服务器解析为：http://ip:port/工程路径/
        * */
        System.out.println("工程部署的路径为： " + servletContext.getRealPath("/"));
        System.out.println("工程下css部署的路径为： " + servletContext.getRealPath("/css"));
        System.out.println("工程下imgs目录下right.png部署的路径为： " + servletContext.getRealPath("/imgs/right.png"));
    }
}
