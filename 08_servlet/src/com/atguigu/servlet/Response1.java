package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("response1");
        //响应码302，表示该地址已被弃用
        /*resp.setStatus(302);
        //响应头，告诉客户端新的访问地址
        resp.setHeader("Location","http://localhost:8080/08_servlet/response2");*/

        //实现请求重定向
        resp.sendRedirect("http://www.baidu.com");
    }
}
