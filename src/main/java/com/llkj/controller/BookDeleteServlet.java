package com.llkj.controller;

import com.llkj.service.impl.BooksServiceImpl;
import com.llkj.utils.ViewServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName BookDeleteServlet
 * @Description TODO
 * @Author qing
 * @Date 2022/11/9 8:51
 * @Version 1.0
 */
@WebServlet("/deleteBook")
public class BookDeleteServlet extends ViewServlet {
    BooksServiceImpl booksService = new BooksServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        booksService.DeleteBookById(Integer.parseInt(id));
        resp.sendRedirect("/allBooks");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
