package com.atguigu.pojo;

import java.awt.*;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.*;

/**
 * 购物车类
 */
public class Cart {
	//总商品数量
	//private Integer totalCount;
	//总商品价格
	//private BigDecimal totalPrice;
	//商品列表
	private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

	/**
	 * 添加商品项
	 *
	 * @param cartItem
	 */
	public void addItem(CartItem cartItem) {
		//首先判断购物车当中是否已经添加过该商品项，如果已添加，该商品项数量累加，总价格更新，如果没有添加，直接放入集合即可
		CartItem item = items.get(cartItem.getId());
		if (item == null) {
			//该商品没有添加过，将商品id作为map集合的商品编号
			items.put(cartItem.getId(), cartItem);
		} else {
			//将该商品的数量累加
			item.setCount(item.getCount() + 1);
			//修改商品的总价格，单价乘以数量，multiply()方法表示乘以，
			item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
		}
	}

	/**
	 * 删除商品项
	 *
	 * @param id
	 */
	public void deleteItem(Integer id) {
		items.remove(id);
	}

	/**
	 * 清空购物车
	 */
	public void clear() {
		items.clear();
	}

	/**
	 * 修改商品数量
	 *
	 * @param id
	 * @param count
	 * @return
	 */
	public void updateCount(Integer id, Integer count) {
		//首先查看购物车是否有此商品，如果有，修改商品数量，更新总金额
		CartItem cartItem = items.get(id);
		if (cartItem != null) {
			cartItem.setCount(count);
			cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
		}
	}

	public Integer getTotalCount() {
		Integer totalCount = 0;
		for (Map.Entry<Integer,CartItem> entry : items.entrySet()) {
			totalCount += entry.getValue().getCount();
		}
		/*for (int i = 0; i < items.size(); i++) {
			totalCount += items.get(i).getCount();
		}*/

		return totalCount;
	}

	/*
	加法      add()函数
	减法      subtract()函数
	乘法      multiply()函数
	除法      divide()函数
	绝对值     abs()函数
	 */
	public BigDecimal getTotalPrice() {
		BigDecimal totalPrice = new BigDecimal(0);

		for (Map.Entry<Integer,CartItem> entry : items.entrySet()) {
			BigDecimal multiply = entry.getValue().getPrice().multiply(new BigDecimal(entry.getValue().getCount()));
			totalPrice = totalPrice.add(multiply);
		}

		return totalPrice;
	}

	public Map<Integer, CartItem> getItems() {
		return items;
	}

	public void setItems(Map<Integer, CartItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Cart{" +
				"totalCount=" + getTotalCount() +
				", totalPrice=" + getTotalPrice() +
				", items=" + items +
				'}';
	}
}
