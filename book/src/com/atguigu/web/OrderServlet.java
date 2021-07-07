package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.JDBCUtils;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class OrderServlet extends BaseServlet {
	private OrderService orderService = new OrderServiceImpl();
	/**
	 * 创建生成订单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取Session域
		HttpSession session = req.getSession();
		//在Session域中获取用户user
		User user = (User) session.getAttribute("user");
		//如果用户user为空，证明用户没有登录，需要跳转到用户登录界面
		if (user == null) {
			req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
			return;
		}
		//在user对象中获取userID用户编号
		Integer userId = user.getId();
		//获取Session域中的购物车Cart
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart",cart);
		}
		//调用OrderService.createOrder(Cart, userId)
		String orderId = orderService.createOrder(cart, userId);;
		/*try {
			orderId = orderService.createOrder(cart, userId);
			//如果执行成功，没有异常那么久提交事务并关闭连接
			JDBCUtils.commitAndClose();
		} catch (Exception e) {
			//如果执行失败，那么捕获异常之后，就回滚事务并关闭连接
			JDBCUtils.rollBackAndClose();
			e.printStackTrace();
		}*/


		//保存到Request域中，请求重定向已经不能再使用Request域中的数据了，应该是用Session域对象
		// req.setAttribute("orderId",orderId);
		//保存到Session域中，使用Session域对象可以避免请求重定向的问题
		session.setAttribute("orderId",orderId);
		//请求重定向回到原来的地址
		//req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
		//请求重定向，防止用户恶意刷新重复提交订单
		resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
	}

	/**
	 * 查询全部订单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取Session域中的cart
		HttpSession session = req.getSession();
		//调用orderService.showAllOrders()
		Map<Integer, Order> orders = orderService.showAllOrders();
		//将map集合 存储到Session域中
		session.setAttribute("orders",orders);
		//请求重定向回到原来的地址
		resp.sendRedirect(req.getHeader("Referer"));
	}

	/**
	 * 发货
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取订单编号和订单状态
		Integer orderId = WebUtils.parseInt(req.getParameter("orderId"), 0);
		Integer status = WebUtils.parseInt(req.getParameter("status"),0);
		//调用orderService.sendOrder()
		orderService.sendOrder(orderId,status);

		//请求重定向回到原来的地址
		resp.sendRedirect(req.getHeader("Referer"));
	}

	/**
	 * 查看订单详情
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取订单编号
		Integer orderId = WebUtils.parseInt(req.getParameter("orderId"), 0);
		//调用orderService.showOrderDetail(orderId)
		OrderItem orderItem = orderService.showOrderDetail(orderId);
		//将数据存储到Session域中
		HttpSession session = req.getSession();
		session.setAttribute("orderItem",orderItem);
		//请求重定向原来的地址
		resp.sendRedirect(req.getHeader("Referer"));
	}

	/**
	 * 查看我的订单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void showMyOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取用户编号
		Integer userId = WebUtils.parseInt(req.getParameter("userId"), 0);
		//调用orderService.showMyOrders(userId)
		Map<Integer, OrderItem> orderItems = orderService.showMyOrder(userId);
		//将数据存储到Session域中
		HttpSession session = req.getSession();
		session.setAttribute("orderItems",orderItems);
		//请求重定向
		resp.sendRedirect(req.getHeader("Referer"));
	}

	/**
	 * 签收订单/确认收货
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void receiverOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取订单编号
		Integer orderId = WebUtils.parseInt(req.getParameter("orderId"), 0);
		//调用orderService.receiverOrder(orderId)
		orderService.receiverOrder(orderId);
		//请求重定向回到原来的地址
		resp.sendRedirect(req.getHeader("Referer"));
	}
}
