package com.llkj.service;

import com.llkj.bean.Books;
import com.llkj.utils.PageUtils;

import java.util.List;

/**
 * @ClassName BooksDao
 * @Description TODO
 * @Author qing
 * @Date 2022/11/7 14:18
 * @Version 1.0
 */
public interface BooksService {
      Integer addBooks(String title, String author, String price, String sales, String stock);
      List<Books> selectAllBooks();
      Integer DeleteBookById(Integer id);
      Integer UpdateBookById(String id,String title, String author, String price, String sales, String stock);

      Books selectBookById(Integer id);
      PageUtils<Books> selectAllBooksLimit(Integer pageIndex);
}
