package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
	//先有订单，然后才有订单项
	//保存订单
	private OrderDao orderDao = new OrderDaoImpl();
	//保存订单项
	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	//需要使用BookDap修改销量和库存
	private BookDao bookDao = new BookDaoImpl();
	/**
	 * 创建生成订单
	 * @param cart
	 * @param userId
	 * @return
	 */
	@Override
	public String createOrder(Cart cart, Integer userId) {
		//让订单项具有唯一性，时间戳+用户ID
		String orderId = System.currentTimeMillis() + "" + userId;
		//创建订单对象   orderId订单编号，new Date()当前时间，totalPrice购物车的总价，0表示未发货，userId表示用户编号
		Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
		//保存订单
		orderDao.saveOrder(order);

		int i = 10 / 0;

		Map<Integer, CartItem> cartItems = cart.getItems();
		for (Map.Entry<Integer,CartItem> entry : cartItems.entrySet()) {
			//去除购物车当中的商品项
			CartItem cartItem = entry.getValue();
			//将购物车的每一个商品项转换成订单当中的订单项
			OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
			//保存订单项到数据库
			orderItemDao.saveOrderItem(orderItem);

			//每当保存一个订单项
			//bookDao通过购物车商品项的id找到Book对象
			Book book = bookDao.queryBookById(cartItem.getId());
			//book商品项的销量+购物车商品项的数量
			book.setSales(book.getSales() + cartItem.getCount());
			//book商品项的库存-购物车商品项的数量
			book.setStock(book.getStock() - cartItem.getCount());
			//更新销量和库存
			bookDao.updateBook(book);
		}
		//将所有的订单都结账之后，需要将购物车清空
		cart.clear();

		return orderId;
	}

	@Override
	public Map<Integer,Order> showAllOrders() {
		Map<Integer, Order> orders = orderDao.queryOrders();
		return orders;
	}

	@Override
	public Integer sendOrder(Integer orderId, Integer status) {
		Order order = orderDao.changeOrderStatus(orderId, status);
		return order.getStatus();
	}

	@Override
	public OrderItem showOrderDetail(Integer orderId) {
		OrderItem orderItem = orderItemDao.queryOrdersByOrderId(orderId);
		return orderItem;
	}

	@Override
	public Map<Integer, OrderItem> showMyOrder(Integer userId) {
		Map<Integer, OrderItem> orderItems = orderDao.queryOrdersByUserId(userId);
		return orderItems;
	}

	@Override
	public void receiverOrder(Integer orderId) {
		Order order = orderDao.changeOrderStatus(orderId, new Order().getStatus());
	}
}
