package com.atguigu.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Base64;

public class Download extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、获取要下载的文件名
		String downloadFileName = "2.jpg";
		//2、读取要下载的文件内容(通过ServletContext对象可以获取)
		ServletContext servletContext = getServletContext();

		//4、在回传前，通过响应头告诉客户端返回的数据类型
		String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
		//获取下载的类型mimeType
		System.out.println("下载的文件类型：" + mimeType);
		//通过响应头告诉客户端返回的数据类型
		resp.setContentType(mimeType);
		//5、还要告诉客户端收到的数据是用于下载使用(还是使用响应头)
		//Content-Disposition响应头，表示收到的数据怎样处理
		//attachment表示附件，表示附件进行下载使用
		//fileName=，表示指定下载的文件名
		//URLEncoder.encode解决文件名中文乱码的 情况
		//resp.setHeader("Content-Disposition","attachment;fileName=" + URLEncoder.encode("美女.jpg","UTF-8"));
		/*
		=?charset?B?xxx?=
		=?表示Base64编码的开始
		charset编码的字符集
		B表示Base64
		xxx表示文件名
		?=表示 Base64编码的结束
		*/
		//如果使用火狐浏览器使用Base64编码
		if (req.getHeader("User-Agent").contains("Firefox")) {
			resp.setHeader("Content-Disposition", "attachment;fileName==?UTF-8?B?" + Base64.getEncoder().encodeToString("美女.jpg".getBytes("UTF-8")) + "?=");
		}
		//如果使用谷歌浏览器使用URLEncoder编码
		else {
			resp.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("美女.jpg", "UTF-8"));
		}
		//获取输入输出流
		/*
		/斜杠被服务器解析为http://IP:port/工程路径/
		 */
		InputStream inputStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
		ServletOutputStream outputStream = resp.getOutputStream();
		//3、把下载的文件内容回传给客户端(通过IOUtils工具类，将输入流的数据复制给输出流)
		IOUtils.copy(inputStream, outputStream);

	}
}
