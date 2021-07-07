package com.atguigu.web;

public class OrderService {
	public void createOrder() {
		String name = Thread.currentThread().getName();
		//使用Map
		//System.out.println("OrderService的线程[" + name + "]获取的数据是：" + ThreadLocalTest.data.get(name));

		//使用ThreadLocal
		System.out.println("OrderService的线程[" + name + "]获取的数据是：" + ThreadLocalTest.threadLocal.get());
		new OrderDao().saveOrder();
	}
}
