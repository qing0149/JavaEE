package com.llkj.dao.impl;

import com.llkj.bean.Books;
import com.llkj.dao.BooksDao;
import com.llkj.utils.DbutilsTools;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BooksDaoImpl
 * @Description TODO
 * @Author qing
 * @Date 2022/11/7 14:18
 * @Version 1.0
 */
public class BooksDaoImpl extends DbutilsTools<Books> implements BooksDao {
    @Override
    public Integer addBooks(String title, String author, Double price, Integer sales, Integer stock) {
        String sql = "insert into books(title,author,price,sales,stock) values(?,?,?,?,?)";
        int update = update(sql, title, author, price, sales, stock);
        return update;
    }

    @Override
    public List<Books> selectAllBooks() {
        String sql = "select id,title,author,price,sales,stock from books";
        List<Books> list = getList(Books.class, sql);
        return list;
    }

    @Override
    public List<Books> selectAllBooksLimit(Integer pageIndex,Integer pageSize) {
        String sql="select id,title,author,price,sales,stock from books limit ?, ? ";
        List<Books> books = getList(Books.class, sql, (pageIndex*pageSize)-pageSize,pageSize);
        return books;
    }

    @Override
    public Integer DeleteBookById(Integer id) {
        String sql = "delete from books where id=?";
        int update = update(sql, id);
        return update;
    }
    @Override
    public Integer UpdateBookById(String id,String title, String author, String price, String sales, String stock) {
        String sql="update books set title=?,author=?,price=?,sales=?,stock=? where id=? ";
        int update = update(sql, title, author, price, sales, stock, id);
        return update;
    }
    @Override
    public Books selectBookById(Integer id) {
        String sql = "select id,title,author,price,sales,stock from books where id=?";
        Books book = getBean(Books.class, sql, id);
        return book;
    }

    @Override
    public Integer CountBooks() {
        String sql="select count(id) from books";
        int update = update(sql);
        return update;
    }
}
