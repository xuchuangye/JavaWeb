package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestParameter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取单个参数值
        System.out.println("获取参数username的值 :" + req.getParameter("username"));
        System.out.println("获取参数password的值 :" + req.getParameter("password"));
        //获取多个参数值
        String[] hobbies = req.getParameterValues("hobby");
        for (String s:hobbies) {
            System.out.println("获取参数hobby的值： " + s);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取单个参数值
        System.out.println("获取参数username的值 :" + req.getParameter("username"));
        System.out.println(req.getMethod());
        //设置请求体的字符集为UTF-8，从而解决post请求中文乱码问题
        //在获取请求参数之前调用才有效，否则会出现乱码
        req.setCharacterEncoding("UTF-8");
        System.out.println("获取参数password的值 :" + req.getParameter("password"));
        //获取多个参数值
        String[] hobbies = req.getParameterValues("hobby");
        for (String s:hobbies) {
            System.out.println("获取参数hobby的值： " + s);
        }
    }
}
