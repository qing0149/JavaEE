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
    Integer addBooks(String title,String author,Double price,Integer sales,Integer stock );
    List<Books> selectAllBooks();
}
