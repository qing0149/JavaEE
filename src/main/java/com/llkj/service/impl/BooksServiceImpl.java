package com.llkj.service.impl;

import com.llkj.bean.Books;
import com.llkj.dao.impl.BooksDaoImpl;
import com.llkj.service.BooksService;

import java.util.List;

/**
 * @ClassName BooksServiceImpl
 * @Description TODO
 * @Author qing
 * @Date 2022/11/7 14:23
 * @Version 1.0
 */
public class BooksServiceImpl implements BooksService {
    BooksDaoImpl booksDaoImpl=new BooksDaoImpl();
    @Override
    public Integer addBooks(String title, String author, String price, String sales, String stock) {
        Integer integer = booksDaoImpl.addBooks(title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock));
        return integer;
    }

    @Override
    public List<Books> selectAllBooks() {
        return booksDaoImpl.selectAllBooks();
    }
    
}
