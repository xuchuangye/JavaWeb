package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("获取当前字符串的字符集： " + resp.getCharacterEncoding());//ISO-8859-1
        //设置服务器的字符集为UTF-8
        //resp.setCharacterEncoding("UTF-8");
        //通过响应头，设置浏览器也是用UTF-8
        //resp.setHeader("Content-Type","text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        //设置服务器和浏览器的字符集，同时还设置了响应头
        //一定要在获取流之前设置，否则没有效果
        resp.setContentType("text/html; charset=UTF-8");

        System.out.println("获取当前字符串的字符集： " + resp.getCharacterEncoding());//UTF-8
        //给客户端回传字符串数据，使用字符流
        writer.write("给客户端回传字符串数据");
    }
}
