package com.atguigu.dao.impl;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
	private BaseDao baseDao = new BookDaoImpl();
	@Override
	public Integer saveOrderItem(OrderItem orderItem) {
		String sql = "insert into t_order_item(name,count,price,total_price,order_id) values(?,?,?,?,?)";
		return baseDao.update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
	}

	@Override
	public OrderItem queryOrdersByOrderId(Integer orderId) {
		return null;
	}
}
