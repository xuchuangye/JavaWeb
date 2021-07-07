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

public class ClientBookServlet extends BaseServlet{
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
		int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
		//2.调用BookService.page(pageNo,pageSize)，返回Page对象
		Page<Book> page = bookService.page(pageNo, pageSize);
		//设置前台的分页请求的地址
		page.setUrl("client/bookServlet?action=page");
		//3.保存Page对象到Request域中
		req.setAttribute("page",page);
		//4.请求转发到/pages/manager/book_manager.jsp页面
		req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
	}

	protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取请求的参数pageNo,pageSize,min,max
		//价格区间内的当前页数。默认是第一页
		Integer pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
		//价格区间内的当前页数显示的数据数量，默认是4个
		Integer pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
		//价格区间的最小值
		Integer min = WebUtils.parseInt(req.getParameter("min"), 0);
		//价格区间的最大值
		Integer max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
		//2.电泳BookService的pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max)
		Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
		StringBuilder builder = new StringBuilder("client/bookServlet?action=pageByPrice");
		//如果有最小价格，追加到分页条请求的地址中
		if (req.getParameter("min") != null) {
			builder.append("&min=").append(req.getParameter("min"));
		}
		//如果有最大价格，追加到分页条请求的地址中
		if (req.getParameter("max") != null) {
			builder.append("&max=").append(req.getParameter("max"));
		}
		//设置前台的分页请求的地址
		page.setUrl(builder.toString());
		//3.保存到Request域中
		req.setAttribute("page",page);
		//4.请求转发到/pages/client/index.jsp
		req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
	}
}
