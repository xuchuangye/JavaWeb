package com.atguigu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//创建实现类MyServletContextListenerImpl实现ServletContextListener接口
public class MyServletContextListenerImpl implements ServletContextListener {
	//实现接口当中的两个抽象方法
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext对象创建成功，现在开始进行初始化");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext对象销毁成功，现在开始进行销毁");
	}
}
