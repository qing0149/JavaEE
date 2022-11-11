package com.llkj.controller;

import cn.hutool.json.JSONUtil;
import com.llkj.bean.Books;
import com.llkj.dao.impl.BooksDaoImpl;
import com.llkj.service.impl.BooksServiceImpl;
import com.llkj.utils.Data;
import com.llkj.utils.PageUtils;
import com.llkj.utils.ViewServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @ClassName BookListServlet
 * @Description TODO
 * @Author qing
 * @Date 2022/11/7 15:11
 * @Version 1.0
 */
@WebServlet("/allBooks")
public class BookListServlet extends ViewServlet{
    BooksServiceImpl booksService=new BooksServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Books> books = booksService.selectAllBooks();
        String pageIndex = req.getParameter("pageIndex");
        PageUtils<Books> booksPageUtils=null;
        if (pageIndex==null){
            booksPageUtils = booksService.selectAllBooksLimit(1);
        }else {
            booksPageUtils = booksService.selectAllBooksLimit(Integer.parseInt(pageIndex));
        }
        req.setAttribute("booksPage",booksPageUtils);
        processTemplate("manager/book_manager",req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
