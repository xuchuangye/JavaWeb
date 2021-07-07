package com.atguigu.web;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class ThreadLocalTest {
	//static的ThreadLocal
	public static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();
	//创建Map集合，因为TheadLocal存储数据和Map类似，key是线程，value是绑定的数据，数据可以是任意类型的
	//public static Map<String, Object> data = new Hashtable<String,Object>();

	//创建随机数对象random
	private static final Random random = new Random();


	public static class Task implements Runnable {

		@Override
		public void run() {
			//随机生成0-999的int类型的数字
			int i = random.nextInt(1000);
			//获取当前线程
			String name = Thread.currentThread().getName();
			System.out.println("ThreadLocalTest存储数据之前的线程[" + name +"]绑定的数据是： " + i);
			//使用Map集合存储数据
			//data.put(name,i);
			//使用ThreadLocal存储数据
			threadLocal.set(i);

			//使用Map集合获取数据
			//Object o = data.get(name);

			//使用ThreadLocal获取数据
			Object o = threadLocal.get();
			System.out.println("ThreadLocalTest的线程[" + name +"]获取的数据是：" + o);


			//处理其他业务，使用时间5秒钟
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			new OrderService().createOrder();
		}
	}

	public static void main(String[] args) {
		//创建三个线程
		for (int i = 0; i < 3; i++) {
			new Thread(new Task()).start();
		}
	}
}
