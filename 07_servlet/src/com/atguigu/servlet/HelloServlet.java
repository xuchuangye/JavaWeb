package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//实现Servlet接口
public class HelloServlet implements Servlet {
    //1.执行Servlet构造器
    public HelloServlet() {
        System.out.println("1.执行Servlet构造器");
    }
    //2.执行init初始化方法
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.执行init初始化方法");

        //1.可以获取Servlet程序的别名servlet-name
        System.out.println("servlet-name是：" + servletConfig.getServletName());
        //2.获取初始化参数init-param
        System.out.println("username的值是：" + servletConfig.getInitParameter("username"));
        //3.获取ServletContext对象
        System.out.println("ServletContext的对象是" + servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    //3.执行service方法
    /**
     * service()方法可以接收客户端的请求和响应数据给客户端
     * @param servletRequest 如何解决Servlet的分发处理问题？使用ServletRequest的子类HttpServletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3.执行service方法");
        //使用ServletRequest的子类HttpServletRequest，通过getMethod()方法获取客户端的请求方式
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        //获取客户端的请求方式
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }

    /**
     * get请求
     */
    public void doGet() {
        System.out.println("get请求");
    }

    /**
     * post请求
     */
    public void doPost() {
        System.out.println("post请求");
    }
    @Override
    public String getServletInfo() {
        return null;
    }

    //4.执行destroy销毁方法
    @Override
    public void destroy() {
        System.out.println("4.执行destroy销毁方法");
    }
}
