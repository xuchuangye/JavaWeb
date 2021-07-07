package com.atguigu.servlet;

import com.atguigu.dao.StudentDao;
import com.atguigu.dao.impl.StudentDaoImpl;
import com.atguigu.pojo.Student;
import com.atguigu.pojo.StudentList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchStudentServlet extends HttpServlet {
	private StudentDao studentDao = new StudentDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取请求的参数
		//2.发送sql语句到数据库去查询学生信息
		//3.保存查询到的结果（学生信息）到request域当中
		List<Student> studentList = StudentList.getStudentList();
		req.setAttribute("stuList",studentList);
		//4.请求转发到showStudent.jsp页面
		req.getRequestDispatcher("/test/showStudent.jsp").forward(req,resp);
	}
}
