package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getRequestURI() 获取请求的资源路径
        String requestURI = req.getRequestURI();
        System.out.println("获取请求的资源路径： " + requestURI);//获取请求的资源路径： /08_servlet/requestServlet
        //getRequestURL() 获取请求的统一资源定位符(绝对路径)
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("获取请求的绝对路径： " + requestURL);//获取请求的绝对路径： http://localhost:8080/08_servlet/requestServlet
        //getRemoteHost() 获取客户端的IP地址
        String remoteHost = req.getRemoteHost();
        //使用localhost:8080访问时，得到的客户端IP地址是127.0.0.1
        //使用127.0.0.1:8080访问时，得到的客户端IP地址是127.0.0.1
        //使用192.168.3.13:8080访问时，得到的客户端IP地址是192.168.3.13
        System.out.println("获取客户端的IP地址： " + remoteHost);//获取客户端的IP地址： 127.0.0.1
        //getHeader() 获取请求头
        System.out.println("获取请求头： " +  req.getHeader("User-Agent"));
        System.out.println("获取请求头： " +  req.getHeader("Accept"));
        System.out.println("获取请求头： " +  req.getHeader("Accept-Language"));
        System.out.println("获取请求头： " +  req.getHeader("Host"));
        //getParameter() 获取请求的参数

        //getParameterValues() 获取请求的参数（多个值的时候使用）

        //getMethod() 获取请求的方式（GET或者POST）
        System.out.println("请求的方式： " + req.getMethod());//请求的方式： GET
        //setAttribute(key,value) 设置域数据

        //getAttribute(key) 获取域数据

        //getRequestDispatcher() 获取请求转发对象
    }
}
