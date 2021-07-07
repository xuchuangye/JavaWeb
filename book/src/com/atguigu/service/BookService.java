package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

public interface BookService {

	//添加Book
	public void addBook(Book book);
	//删除Book
	public void deleteBookById(Integer id);
	//修改Book
	public void updateBook(Book book);
	//查询单个Book
	public Book queryBookById(Integer id);
	//查询多个Book的list集合
	public List<Book> queryBooks();
	//处理图书的分页业务
	public Page<Book> page(Integer pageNo,Integer pageSize);
	//处理价格区间内的分页业务
	public Page<Book> pageByPrice(Integer pageNo,Integer pageSize, Integer min, Integer max);
}
