package com.atguigu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//1.继承HttpServlet类
public class HelloServlet2 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        //重写GenericServlet类的init()一定要调用GenericServlet类的init()，因为GenericServlet类的init()保留了config信息
        super.init(config);
        System.out.println("重写了 GenericServlet的init方法");
    }

    //2.重写doGet方法和doPost方法
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2 doGet()");
        ServletConfig servletConfig = getServletConfig();
        System.out.println("初始化username的参数值是：" + servletConfig.getInitParameter("username"));
        System.out.println("初始化url的参数值是：" + servletConfig.getInitParameter("url"));
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet doPost()");
    }
}
