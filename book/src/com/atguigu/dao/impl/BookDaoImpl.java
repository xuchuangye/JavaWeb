package com.atguigu.dao.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
	@Override
	public int addBook(Book book) {
		String sql = "insert into t_book(id,name,author,price,sales,stock,img_path) values(?,?,?,?,?,?,?)";
		return update(sql,book.getId(),book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
	}

	@Override
	public int updateBook(Book book) {
		String sql = "update t_book set name = ?,author = ?,price = ?,sales = ?,stock = ?,img_path = ? where id= ?";
		return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
	}

	@Override
	public int deleteBookById(Integer id) {
		String sql = "delete from t_book where id =? ";
		return update(sql,id);
	}

	@Override
	public Book queryBookById(Integer id) {
		String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book where id = ?";
		return selectForOne(Book.class,sql,id);
	}

	@Override
	public List<Book> queryBooks() {
		String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book";
		return selectForMany(Book.class,sql);
	}

	@Override
	public int queryForPageTotalCount() {
		String sql = "select count(*) from t_book";
		Number count = (Number) selectForSingleValue(sql);
		return count.intValue();
	}

	@Override
	public List<Book> queryForPagesItems(Integer begin,Integer pageSize) {
		String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book limit ?,?";
		return selectForMany(Book.class,sql,begin,pageSize);
	}

	@Override
	public int queryForPricePageTotalCount(Integer min, Integer max) {
		String sql = "select count(*) from t_book where price between ? and ?";
		Number count = (Number) selectForSingleValue(sql, min, max);
		return count.intValue();
	}

	@Override
	public List<Book> queryForPricePagesItems(Integer begin, Integer pageSize, Integer min, Integer max) {
		String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book where price between ? and ? order by price limit ?,?";
		return selectForMany(Book.class,sql,min,max,begin,pageSize);
	}
}
