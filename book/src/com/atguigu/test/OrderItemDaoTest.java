package com.atguigu.test;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderItemDaoTest {

	@Test
	public void saveOrderItem() {
		OrderItemDao orderItemDao = new OrderItemDaoImpl();
		OrderItem orderItem1 = new OrderItem(null,"Java从入门到精通",1,new BigDecimal(100),new BigDecimal(100),"1234567890");
		OrderItem orderItem2 = new OrderItem(null,"JavaScript从入门到精通",1,new BigDecimal(150),new BigDecimal(150),"1234567890");
		OrderItem orderItem3 = new OrderItem(null,"Python从入门到入土",1,new BigDecimal(200),new BigDecimal(200),"1234567890");
		orderItemDao.saveOrderItem(orderItem1);
		orderItemDao.saveOrderItem(orderItem2);
		orderItemDao.saveOrderItem(orderItem3);
	}
}