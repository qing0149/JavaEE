package com.llkj.controller;

import com.llkj.service.impl.BooksServiceImpl;
import com.llkj.utils.ViewServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName BookAddServlet
 * @Description TODO
 * @Author qing
 * @Date 2022/11/9 8:53
 * @Version 1.0
 */
//@WebServlet("/addBooks")
public class BookAddServlet extends ViewServlet {
    BooksServiceImpl booksService= new BooksServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String price = req.getParameter("price");
        String author = req.getParameter("author");
        String sales = req.getParameter("sales");
        String stock = req.getParameter("stock");
        Integer integer = booksService.addBooks(title, author, price, sales, stock);
        resp.sendRedirect("/allBooks");
    }
}
