package com.atguigu.dao;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

public interface BookDao {
	//添加Book
	public int addBook(Book book);
	//修改Book
	public int updateBook(Book book);
	//删除Book
	public int deleteBookById(Integer id);
	//查询单个Book
	public Book queryBookById(Integer id);
	//查询多个Book的list集合
	public List<Book> queryBooks();
	//查询总记录数
	public int queryForPageTotalCount();
	//查询当前页数据
	public List<Book> queryForPagesItems(Integer begin,Integer pageSize);
	//查询价格区间内的总记录数
	public int queryForPricePageTotalCount(Integer min,Integer max);
	//查询价格区间内当前页面显示的数据个数
	public List<Book> queryForPricePagesItems(Integer begin,Integer pageSize,Integer min,Integer max);
}
