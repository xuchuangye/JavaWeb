package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookServiceTest {
	private BookService bookService = new BookServiceImpl();
	@Test
	public void addBook() {
		bookService.addBook(new Book(null,"我为什么这么帅","xcy",new BigDecimal(55),100,100,null));
		System.out.println("添加成功");
	}

	@Test
	public void deleteBookById() {
		bookService.deleteBookById(22);
		System.out.println("删除成功");
	}

	@Test
	public void updateBook() {
		bookService.updateBook(new Book(23,"我真的好帅","xcy666",new BigDecimal(66),100000,133200,null));
		System.out.println("更新成功");
	}

	@Test
	public void queryBookById() {
		Book book = bookService.queryBookById(23);
		System.out.println(book);
	}

	@Test
	public void queryBooks() {
		List<Book> books = bookService.queryBooks();
		for (Book book : books) {
			System.out.println(book);
		}
	}
	@Test
	public void page() {
		Page<Book> page = bookService.page(1,Page.PAGE_SIZE);
		System.out.println(page);
	}

	@Test
	public void pageByPrice() {
		Page<Book> page = bookService.pageByPrice(1, Page.PAGE_SIZE, 10, 50);
		System.out.println(page);
	}
}