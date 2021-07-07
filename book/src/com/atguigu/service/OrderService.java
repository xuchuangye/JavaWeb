package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

import java.util.Map;

public interface OrderService {
	//创建订单
	public String createOrder(Cart cart, Integer userId);
	//查询所有的订单
	public Map<Integer,Order> showAllOrders();
	//发货
	public Integer sendOrder(Integer orderId, Integer status);
	//查询订单详情
	public OrderItem showOrderDetail(Integer orderId);
	//查看我的订单
	public Map<Integer,OrderItem> showMyOrder(Integer userId);
	//确认收货/签收订单
	public void receiverOrder(Integer orderId);
}
