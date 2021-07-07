package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
	private BookDao bookDao = new BookDaoImpl();
	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}
	@Override
	public void deleteBookById(Integer id) {
		bookDao.deleteBookById(id);
	}

	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	@Override
	public Book queryBookById(Integer id) {
		return bookDao.queryBookById(id);
	}

	@Override
	public List<Book> queryBooks() {
		return bookDao.queryBooks();
	}

	@Override
	public Page<Book> page(Integer pageNo, Integer pageSize) {
		Page<Book> page = new Page<Book>();
		//设置当前页显示的数量
		page.setPageSize(pageSize);
		//求总记录数
		Integer pageTotalCount = bookDao.queryForPageTotalCount();
		//设置总记录数
		page.setPageTotalCount(pageTotalCount);
		//设置总页数
		Integer pageTotal = pageTotalCount / pageSize;
		if (pageTotalCount % pageSize > 0) {
			pageTotal += 1;
		}
		page.setPageTotal(pageTotal);
		//设置当前页码
		page.setPageNo(pageNo);
		//获取当前页数据的开始索引
		Integer begin = (page.getPageNo() - 1) * pageSize ;
		//设置显示的数据
		List<Book> items = bookDao.queryForPagesItems(begin, pageSize);
		page.setItems(items);

		return page;
	}

	@Override
	public Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max) {
		Page<Book> page = new Page<Book>();
		//设置当前页显示的数量
		page.setPageSize(pageSize);
		//求总记录数
		Integer pageTotalCount = bookDao.queryForPricePageTotalCount(min,max);
		//设置总记录数
		page.setPageTotalCount(pageTotalCount);
		//设置总页数
		Integer pageTotal = pageTotalCount / pageSize;
		if (pageTotalCount % pageSize > 0) {
			pageTotal += 1;
		}
		page.setPageTotal(pageTotal);
		//设置当前页码
		page.setPageNo(pageNo);
		//获取当前页数据的开始索引
		Integer begin = (page.getPageNo() - 1) * pageSize ;
		//设置显示的数据
		List<Book> items = bookDao.queryForPricePagesItems(begin, pageSize,min,max);
		page.setItems(items);

		return page;
	}
}
