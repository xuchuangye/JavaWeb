package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

import java.util.Map;

public class OrderDaoImpl extends BaseDao implements OrderDao {
	private BaseDao baseDao = new BookDaoImpl();

	@Override
	public Integer saveOrder(Order order) {
		String sql = "insert into t_order(order_id,create_time,price,status,user_id) values(?,?,?,?,?)";
		int update = baseDao.update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
		return update;
	}

	@Override
	public Map<Integer, Order> queryOrders() {
		return null;
	}

	@Override
	public Order changeOrderStatus(Integer orderId, Integer status) {
		return null;
	}

	@Override
	public Map<Integer, OrderItem> queryOrdersByUserId(Integer userId) {
		return null;
	}
}
