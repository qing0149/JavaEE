package com.llkj.service.impl;

import com.llkj.bean.Books;
import com.llkj.dao.impl.BooksDaoImpl;
import com.llkj.service.BooksService;
import com.llkj.utils.Data;
import com.llkj.utils.PageUtils;

import java.util.List;

/**
 * @ClassName BooksServiceImpl
 * @Description TODO
 * @Author qing
 * @Date 2022/11/7 14:23
 * @Version 1.0
 */
public class BooksServiceImpl implements BooksService {
    BooksDaoImpl booksDao = new BooksDaoImpl();

    @Override
    public Integer addBooks(String title, String author, String price, String sales, String stock) {
        Integer integer = booksDao.addBooks(title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock));
        return integer;
    }

    @Override
    public List<Books> selectAllBooks() {
        return booksDao.selectAllBooks();
    }

    @Override
    public Integer DeleteBookById(Integer id) {
        Integer uid = booksDao.DeleteBookById(id);
        return uid;
    }

    @Override
    public Integer UpdateBookById(String id, String title, String author, String price, String sales, String stock) {
        Integer integer = booksDao.UpdateBookById(id, title, author, price, sales, stock);
        return integer;
    }

    @Override
    public Books selectBookById(Integer id) {
        Books books = booksDao.selectBookById(id);
        return books;
    }

    @Override
    public PageUtils<Books> selectAllBooksLimit(Integer pageIndex) {
        //设置传输数据
        PageUtils<Books> booksPageUtils = new PageUtils<>();
        List<Books> books = booksDao.selectAllBooksLimit(pageIndex, Data.PAGESIZE);
        booksPageUtils.setDataList(books);
//        设置页面大小
        booksPageUtils.setPageSize(Data.PAGESIZE);
        //设置总页数
        int size = booksDao.selectAllBooks().size();
        booksPageUtils.setTotalCount(size);
        //设置当前页位置
        booksPageUtils.setPageIndex(pageIndex);
        //设置
        booksPageUtils.setTotalPages((size/Data.PAGESIZE)+1);
        return booksPageUtils;
    }
}
