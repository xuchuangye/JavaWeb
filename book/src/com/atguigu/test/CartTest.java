package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;

public class CartTest {

	@Test
	public void addItem() {
		Cart cart = new Cart();
		CartItem cartItem1 = new CartItem(1,"Java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000));
		CartItem cartItem2 = new CartItem(1,"Java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000));
		CartItem cartItem3 = new CartItem(2,"数据结构与算法",1,new BigDecimal(1500),new BigDecimal(1000));
		cart.addItem(cartItem1);
		cart.addItem(cartItem2);
		cart.addItem(cartItem3);
		System.out.println(cart);
	}

	@Test
	public void deleteItem() {
		Cart cart = new Cart();
		CartItem cartItem1 = new CartItem(1,"Java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000));
		CartItem cartItem2 = new CartItem(1,"Java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000));
		CartItem cartItem3 = new CartItem(2,"数据结构与算法",1,new BigDecimal(1500),new BigDecimal(1000));
		cart.addItem(cartItem1);
		cart.addItem(cartItem2);
		cart.addItem(cartItem3);
		cart.deleteItem(1);
		System.out.println(cart);
	}

	@Test
	public void clear() {
		Cart cart = new Cart();
		CartItem cartItem1 = new CartItem(1,"Java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000));
		CartItem cartItem2 = new CartItem(1,"Java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000));
		CartItem cartItem3 = new CartItem(2,"数据结构与算法",1,new BigDecimal(1500),new BigDecimal(1000));
		cart.addItem(cartItem1);
		cart.addItem(cartItem2);
		cart.addItem(cartItem3);
		cart.deleteItem(1);
		cart.clear();
		System.out.println(cart);
	}

	@Test
	public void updateCount() {
		Cart cart = new Cart();
		CartItem cartItem1 = new CartItem(1,"Java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000));
		CartItem cartItem2 = new CartItem(1,"Java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000));
		CartItem cartItem3 = new CartItem(2,"数据结构与算法",1,new BigDecimal(1500),new BigDecimal(1000));
		cart.addItem(cartItem1);
		cart.addItem(cartItem2);
		cart.addItem(cartItem3);
		cart.deleteItem(1);
		cart.clear();
		cart.addItem(cartItem1);
		cart.updateCount(1,10);
		System.out.println(cart);
	}
}