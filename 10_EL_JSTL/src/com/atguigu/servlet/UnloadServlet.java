package com.atguigu.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UnloadServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.首先判断上传的数据是否是多段数据（只有多段数据才是文件上传的）
		if (ServletFileUpload.isMultipartContent(req)) {
			//2.创建FileItemFactory工厂实现类DiskFileItemFactory
			FileItemFactory fileItemFactory = new DiskFileItemFactory();
			//3.创建用于解析上传数据的工具类ServletFileUpload类
			ServletFileUpload  servletFileUpload = new ServletFileUpload(fileItemFactory);
			//4.解析上传的数据，得到每一个表单项FileItem
			try {
				List<FileItem> list = servletFileUpload.parseRequest(req);

				//5.循环判断每一个表单项是普通类型，还是上传的文件
				for (FileItem fileitem : list) {
					//普通表单项，获取name属性和value值（参数设置为UTF-8解决乱码问题）
					if (fileitem.isFormField()) {
						System.out.println("获取表单项的name属性值:" + fileitem.getFieldName());
						System.out.println("获取表单项的value值:" + fileitem.getString("UTF-8"));
					}

					//上传的文件，获取name属性和文件名
					else {
						System.out.println("获取表单项的name属性: " + fileitem.getFieldName());
						System.out.println("获取上传的文件名: " + fileitem.getName());
						fileitem.write(new File("E:\\" + fileitem.getName()));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}


		}
	}
}
