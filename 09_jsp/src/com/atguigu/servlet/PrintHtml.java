package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintHtml extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");

		PrintWriter writer = resp.getWriter();
		writer.write("<!DOCTYPE html>");
		writer.write("<html lang=\"en\">");
		writer.write("<head>");
		writer.write("<meta charset=\"UTF-8\">");
		writer.write("<title>CSS选择器</title>");
		writer.write("</head>");
		writer.write("<body>");
		writer.write("这是一个html页面");
		writer.write("</body>");
		writer.write("</html>");
	}
}
