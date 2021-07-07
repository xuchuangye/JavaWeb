package com.atguigu.util;

import javax.servlet.http.Cookie;

public class CookieUtils {
	/**
	 * 根据name(key名)在数组cookies当中查询某一个cookie对象
	 * @param name 需要查询的key的名字
	 * @param cookies 需要查询的cookies的数组
	 * @return
	 */
	public static Cookie findCookie(String name,Cookie[] cookies) {
		if (name == null || cookies == null || cookies.length == 0) {
			return null;
		}

		for (Cookie cookie : cookies) {
			if (name.equals(cookie.getName())) {
				return  cookie;
			}
		}
		
		return null;
	}
}
