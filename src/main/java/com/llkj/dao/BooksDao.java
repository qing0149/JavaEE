package com.llkj.dao;

import com.llkj.bean.Books;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BooksDao
 * @Description TODO
 * @Author qing
 * @Date 2022/11/7 14:18
 * @Version 1.0
 */
public interface BooksDao {
    Integer addBooks(String title, String author, Double price, Integer sales, Integer stock);

    List<Books> selectAllBooks();
    List<Books> selectAllBooksLimit(Integer pageIndex,Integer pageSize);

    Integer DeleteBookById(Integer id);

    Integer UpdateBookById(String id,String title, String author, String price, String sales, String stock);

    Books selectBookById(Integer id);
    Integer CountBooks();

}
