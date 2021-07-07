package com.atguigu.utils;

import com.atguigu.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

//import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class WebUtils {
	/**
	 *
	 * @param bean JavaBean对象
	 * @param request 参数类型HttpServletRequest耦合度比较高，而且不灵活，只能在web层面使用，无法在service层和DAO层使用
	 */
	/*public static void copyParamToBean(Object bean, HttpServletRequest request) {
		try {
			BeanUtils.populate(bean,request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 *
	 * @param bean JavaBean对象
	 * @param map 既然最终总是要获取Map集合，那么可以将HttpServletRequest替换为Map集合，增加灵活性，降低耦合度
	 */
	/*public static void copyParamToBean(Object bean, Map map) {
		try {
			BeanUtils.populate(bean,map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/


	/**
	 * 因为User user = WebUtils.copyParamToBean(new User(), req.getParameterMap());
	 * 所以需要将该方法的返回值类型改为User，并添加语return Bean对象的语句
	 * @param bean User对象
	 * @param map Map集合
	 */
	/*public static User copyParamToBean(User bean, Map map) {
		try {
			BeanUtils.populate(bean,map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}*/

	/**
	 * 可以使用泛型做进一步的修改
	 * @param bean T类型
	 * @param map Map集合
	 * @return
	 */
	public static <T> T copyParamToBean(T bean, Map map) {
		try {
			BeanUtils.populate(bean,map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	/**
	 * 将String类型转换成Integer类型的数据
	 * @param str 需要被转换类型的变量
	 * @return
	 */
	public static Integer parseInt(String str,Integer defaultValue) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return defaultValue;
	}
}
