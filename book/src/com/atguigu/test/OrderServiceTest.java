package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderServiceTest {

	@Test
	public void createOrder() {

		Cart cart = new Cart();
		CartItem cartItem1 = new CartItem(1, "Java从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000));
		CartItem cartItem2 = new CartItem(1, "Java从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000));
		CartItem cartItem3 = new CartItem(2, "数据结构与算法", 1, new BigDecimal(1500), new BigDecimal(1000));
		cart.addItem(cartItem1);
		cart.addItem(cartItem2);
		cart.addItem(cartItem3);
		OrderService orderService = new OrderServiceImpl();
		Integer userId = 1;
		System.out.println("订单号是： " + orderService.createOrder(cart, userId));

	}
}