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
        String sql="insert into books(title,author,price,sales,stock) values(?,?,?,?,?)";
        int update = update(sql, title, author, price, sales, stock);
        return update;
    }

    @Override
    public List<Books> selectAllBooks() {
        String sql="select title,author,price,sales,stock from books";
        List<Books> list = getList(Books.class, sql);
        return list;
    }

}
