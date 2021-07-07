package com.atguigu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //直接获取ServletContext上下文对象
        ServletContext servletContext = getServletContext();
        System.out.println(servletContext);
        System.out.println("保存之前的servletContext当中属性key1的值是： " + servletContext.getAttribute("key1"));
        //设置属性
        servletContext.setAttribute("key1","value1");
        //获取属性
        System.out.println("servletContext当中属性key1的值是： " + servletContext.getAttribute("key1"));
        System.out.println("servletContext当中属性key1的值是： " + servletContext.getAttribute("key1"));
        System.out.println("servletContext当中属性key1的值是： " + servletContext.getAttribute("key1"));
        System.out.println("servletContext当中属性key1的值是： " + servletContext.getAttribute("key1"));
    }
}
