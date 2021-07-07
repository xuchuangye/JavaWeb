package com.atguigu.dao;

import com.atguigu.pojo.OrderItem;

public interface OrderItemDao  {
	public Integer saveOrderItem(OrderItem orderItem);
	//根据订单号查询订单的明细
	public OrderItem queryOrdersByOrderId(Integer orderId);
}
