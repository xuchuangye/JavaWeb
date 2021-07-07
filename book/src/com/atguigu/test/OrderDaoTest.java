package com.atguigu.test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDaoTest {

	@Test
	public void saveOrder() {
		OrderDao orderDao  = new OrderDaoImpl();
		Order order1 = new Order("1234567890",new Date(),new BigDecimal(100),0,1);
		Order order2 = new Order("1234567891",new Date(),new BigDecimal(150),0,2);
		Order order3 = new Order("1234567892",new Date(),new BigDecimal(200),0,1);
		orderDao.saveOrder(order1);

	}
}