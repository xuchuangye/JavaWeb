package com.atguigu.servlet;

import com.atguigu.pojo.Student;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class AJAXServlet extends BaseServlet {

	/**
	 * 原生的AJAX请求
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void javaScriptAJAX(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("原生的AJAX请求");
		Student student = new Student(1,"张曼玉",30,new BigDecimal(100));
		//发送给服务器之前，需要将JavaBean对象转换成json格式的字符串
		Gson gson = new Gson();
		String studentJsonString = gson.toJson(student);
		//System.out.println(studentJsonString);
		resp.getWriter().write(studentJsonString);
	}

	/**
	 * jQuery的AJAX请求的ajax方法
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void jQueryAJAX(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("jQueryAJAX请求的ajax方法");
		Student student = new Student(1,"张曼玉",30,new BigDecimal(100));
		//发送给服务器之前，需要将JavaBean对象转换成json格式的字符串
		Gson gson = new Gson();
		String studentJsonString = gson.toJson(student);
		//System.out.println(studentJsonString);
		resp.getWriter().write(studentJsonString);
	}

	/**
	 * jQuery的AJAX请求的get方法
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("jQueryAJAX请求的get方法");
		Student student = new Student(1,"张曼玉",30,new BigDecimal(100));
		//发送给服务器之前，需要将JavaBean对象转换成json格式的字符串
		Gson gson = new Gson();
		String studentJsonString = gson.toJson(student);
		//System.out.println(studentJsonString);
		resp.getWriter().write(studentJsonString);
	}

	/**
	 * jQuery的AJAX请求的post方法
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("jQueryAJAX请求的post方法");
		Student student = new Student(1,"张曼玉",30,new BigDecimal(100));
		//发送给服务器之前，需要将JavaBean对象转换成json格式的字符串
		Gson gson = new Gson();
		String studentJsonString = gson.toJson(student);
		//System.out.println(studentJsonString);
		resp.getWriter().write(studentJsonString);
	}

	/**
	 * jQuery的AJAX请求的getJSON方法
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void jQueryGetJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("jQueryAJAX请求的getJSON方法");
		Student student = new Student(1,"张曼玉",30,new BigDecimal(100));
		//发送给服务器之前，需要将JavaBean对象转换成json格式的字符串
		Gson gson = new Gson();
		String studentJsonString = gson.toJson(student);
		//System.out.println(studentJsonString);
		resp.getWriter().write(studentJsonString);
	}

	/**
	 * jQuery的AJAX请求的serialize()可序列化方法
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("jQueryAJAX请求的getJSON方法");
		//获取请求的参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		Student student = new Student(1,"张曼玉",30,new BigDecimal(100));
		//发送给服务器之前，需要将JavaBean对象转换成json格式的字符串
		Gson gson = new Gson();
		String studentJsonString = gson.toJson(student);
		//System.out.println(studentJsonString);
		resp.getWriter().write(studentJsonString);
	}
}
