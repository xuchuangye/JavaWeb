package com.atguigu.dao;

import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

import java.util.Map;

public interface OrderDao {
	//保存订单
	public Integer saveOrder(Order order);
	//查询全部订单
	public Map<Integer,Order> queryOrders();
	//修改订单的状态
	public Order changeOrderStatus(Integer orderId, Integer status);
	//根据用户编号查询订单信息
	public Map<Integer, OrderItem> queryOrdersByUserId(Integer userId);
}
