package com.llkj.controller;

import com.llkj.bean.Books;
import com.llkj.dao.impl.BooksDaoImpl;
import com.llkj.service.impl.BooksServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName BookListServlet
 * @Description TODO
 * @Author qing
 * @Date 2022/11/7 15:11
 * @Version 1.0
 */
@WebServlet("/allBooks")
public class BookListServlet extends HttpServlet {
    BooksServiceImpl booksService=new BooksServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Books> books = booksService.selectAllBooks();
        System.out.println(books);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
