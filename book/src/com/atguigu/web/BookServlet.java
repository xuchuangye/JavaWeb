package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
	private BookService bookService = new BookServiceImpl();

	/**
	 * 处理分页业务
	 * @param req 请求
	 * @param resp 响应
	 * @throws ServletException
	 * @throws IOException
	 */

	protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取请求的参数pageNo和pageSize
		//当前页数。默认是第一页
		int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
		//当前页数显示的数据数量，默认是4个
		int pageSize = WebUtils.parseInt(req.getParameter("pageSize"),Page.PAGE_SIZE);
		//2.调用BookService.page(pageNo,pageSize)，返回Page对象
		Page<Book> page = bookService.page(pageNo, pageSize);
		//设置后台的分页请求的地址
		page.setUrl("manager/bookServlet?action=page");
		//3.保存Page对象到Request域中
		req.setAttribute("page",page);
		//4.请求转发到/pages/manager/book_manager.jsp页面
		req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
	}

	protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),0);
		pageNo += 1;
		//获取请求的参数封装成Bean对象
		Book book = WebUtils.copyParamToBean(new Book(), req.getParameterMap());
		//将封装的Bean对象添加到数据库
		bookService.addBook(book);
		//请求转发到/manager/bookServlet?action=list，但是用户每次刷新都会添加，所以使用请求重定向
		//req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
		resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取请求的参数id,图书编程
		int id_ = WebUtils.parseInt(req.getParameter("id"), 0);
		// 调用bookService.deleteBookByld();删除图书
		bookService.deleteBookById(id_);
		// 重定向回图书列表管理页面/manager/bookServlet?action=list
		resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
	}

	protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、获取诗求的参数==封装成为Book对象|
		Book book = WebUtils.copyParamToBean(new Book(), req.getParameterMap());
		//2、周用BookService.updateBook( book );修改图书
		bookService.updateBook(book);
		//3、重定向回图书列表管理页面
		resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
	}

	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.通过BookService查询全部图片
		List<Book> books = bookService.queryBooks();
		//2.把全部图书保存到Request域中
		req.setAttribute("list", books);
		//3.请求转发到/pages/manager/book_manager.jsp页面
		req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
	}

	protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取参数图书编号id
		Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
		//2.调用bookService.queryBookById()
		Book book = bookService.queryBookById(id);
		//3.保存数据到Request域中
		req.setAttribute("book", book);
		//4.请求转发到pages/manager/book_edit.jsp
		req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
	}
}
