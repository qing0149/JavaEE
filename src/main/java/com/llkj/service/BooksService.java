package com.llkj.service;

import com.llkj.bean.Books;

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
}
