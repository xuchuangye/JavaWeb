package com.atguigu.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class i18nTest {

	@Test
	public void testLocale() {
		//获取默认的国家语言信息
		Locale locale = Locale.getDefault();
		System.out.println(locale);//zh_CN

		for (Locale availableLocale : Locale.getAvailableLocales()) {
			System.out.println(availableLocale);
		}
		//获取中文
		System.out.println(Locale.CHINA);
		//获取英文
		System.out.println(Locale.US);
		//关闭locale
		locale.clone();
	}

	@Test
	public void testi18n() {

		//获取Locale对象
		Locale locale = Locale.CHINA;
		//通过baseName和Locale对象获取ResourceBundle子类的对象
		ResourceBundle i18n = ResourceBundle.getBundle("i18n", locale);
		//打印输出
		System.out.println("username=" + i18n.getString("username"));
		System.out.println("password=" + i18n.getString("password"));
		System.out.println("sex=" + i18n.getString("sex"));
		System.out.println("age=" + i18n.getString("age"));

		locale.clone();
	}
}
