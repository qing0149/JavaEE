package com.llkj.controller;

import com.llkj.dao.impl.BooksDaoImpl;
import com.llkj.service.impl.BooksServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName BookServlet
 * @Description TODO
 * @Author qing
 * @Date 2022/11/7 14:47
 * @Version 1.0
 */
@WebServlet("/addBooks")
public class BookServlet extends HttpServlet {
    BooksServiceImpl booksServiceImpl= new BooksServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String price = req.getParameter("price");
        String sales = req.getParameter("sales");
        String stock = req.getParameter("stock");
        Integer integer = booksServiceImpl.addBooks(title,author,price,sales,stock);
        if (integer>0){
            resp.sendRedirect("/pages/manager/book_manager.html");
        }else {
            resp.sendRedirect("/pages/manager/book_manager.html");
        }
    }
}
