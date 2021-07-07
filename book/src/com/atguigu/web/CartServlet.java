package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class CartServlet extends BaseServlet {
	private BookService bookService = new BookServiceImpl();

	/**
	 * 使用 AJAX请求将商品添加到购物车
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//获取商品编号
		Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
		//System.out.println("商品编号：" + id);
		//调用bookService.queryBookById()通过ID查询book
		Book book = bookService.queryBookById(id);
		//将book转换成CartItem
		CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
		//将CartItem添加到Session域中
		HttpSession session = req.getSession();


		//先查看Session域中是否有该购物车，如果没有则创建一个并添加到Session域中
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		//如果Session域中有该购物车Cart，那么直接将商品项CartItem添加到购物车中即可
		cart.addItem(cartItem);

		//获取最后一次添加的商品名称
		session.setAttribute("lastName", cartItem.getName());

		Map<String, Object> resultMap = new HashMap<String, Object>();
		//添加商品总数
		resultMap.put("totalCount", cart.getTotalCount());
		resultMap.put("lastName", cartItem.getName());

		Gson gson = new Gson();
		String mapJsonString = gson.toJson(resultMap);
		resp.getWriter().write(mapJsonString);
	}

	/**
	 * 加入购物车
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取商品编号
		Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
		//System.out.println("商品编号：" + id);
		//调用bookService.queryBookById()通过ID查询book
		Book book = bookService.queryBookById(id);
		//将book转换成CartItem
		CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
		//将CartItem添加到Session域中
		HttpSession session = req.getSession();


		//先查看Session域中是否有该购物车，如果没有则创建一个并添加到Session域中
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		//如果Session域中有该购物车Cart，那么直接将商品项CartItem添加到购物车中即可
		cart.addItem(cartItem);

		//获取最后一次添加的商品名称
		session.setAttribute("lastName", cartItem.getName());
		//请求重定向回到商品列表页面
		//resp.sendRedirect(req.getContextPath());
		//重定向商品原来id所在的位置
		resp.sendRedirect(req.getHeader("Referer"));
	}

	/**
	 * 删除商品项
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取商品编号
		Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
		/*//调用bookService.deleteBookById()通过编号查询Book
		Book book = bookService.queryBookById(id);
		//将book转换成CartItem
		CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());*/

		//将CartItem添加到Session域中
		HttpSession session = req.getSession();

		//先查看Session域中是否有该购物车，如果没有则创建一个并添加到Session域中
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		//从购物车中获取指定商品编号的商品项

		//如果Session域中有该购物车Cart，那么直接在购物车中删除商品项CartItem
		cart.deleteItem(id);

		//重定向商品原来id所在的位置
		resp.sendRedirect(req.getHeader("Referer"));
	}

	/**
	 * 清空购物车
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//bookService.queryBooks()通过ID查询Book
		/*List<Book> books = bookService.queryBooks();
		Map<Integer,CartItem> cartItems = new LinkedHashMap<Integer, CartItem>();
		//foreach循环遍历将book转换成CartItem
		for (Book book : books) {
			CartItem cartItem  = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
			cartItems.put(cartItem.getId(),cartItem);
		}*/
		//将CartItem添加到Session域中
		HttpSession session = req.getSession();

		//先查看Session域中是否有该购物车，如果没有则创建一个并添加到Session域中
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		//如果Session域中有该购物车Cart，那么直接清空购物车
		cart.clear();
		//请求重定向回到原来ID所在的我位置
		resp.sendRedirect(req.getHeader("Referer"));
	}

	/**
	 * 修改购物车商品数量
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取商品编号
		Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
		Integer count = WebUtils.parseInt(req.getParameter("count"), 1);

		//获取Session域中的购物车
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		//如果有购物车cart，则修改商品的数量
		cart.updateCount(id, count);
		//请求重定向回到原来ID所在的我位置
		resp.sendRedirect(req.getHeader("Referer"));
	}
}
