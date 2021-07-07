package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookDaoTest {
	private BookDao bookDao = new BookDaoImpl();

	@Test
	public void addBook() {
		bookDao.addBook(new Book(null, "我为什么这么帅", "xcy", new BigDecimal(55), 100, 100, null));
	}

	@Test
	public void updateBook() {
		bookDao.updateBook(new Book(4, "鱼肉盖饭", "小胖墩", new BigDecimal(20), 1000, 500, null));

	}

	@Test
	public void deleteBookById() {
		bookDao.deleteBookById(21);
	}

	@Test
	public void queryBookById() {
		Book book = bookDao.queryBookById(20);
		System.out.println(book);
	}

	@Test
	public void queryBooks() {
		List<Book> books = bookDao.queryBooks();
		books.forEach(System.out::print);
	}

	@Test
	public void queryForPageTotalCount() {
		int pageTotalCount = bookDao.queryForPageTotalCount();
		System.out.println(pageTotalCount);

	}
	@Test
	public void queryForPricePageTotalCount() {
		int pageTotalCount = bookDao.queryForPricePageTotalCount(10,50);
		System.out.println(pageTotalCount);

	}

	@Test
	public void queryForIPagesItems() {
		int begin = 8;
		List<Book> items = bookDao.queryForPagesItems(begin, Page.PAGE_SIZE);
		items.forEach(System.out::println);
	}
	@Test
	public void queryForPriceIPagesItems() {
		int begin = 0;
		List<Book> items = bookDao.queryForPricePagesItems(begin, Page.PAGE_SIZE,10,60);
		items.forEach(System.out::println);
	}

}