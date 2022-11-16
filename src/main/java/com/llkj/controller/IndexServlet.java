package com.llkj.controller;

import com.llkj.bean.Books;
import com.llkj.service.impl.BooksServiceImpl;
import com.llkj.utils.PageUtils;
import com.llkj.utils.ViewServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName IndexServlet
 * @Description TODO
 * @Author qing
 * @Date 2022/11/10 15:50
 * @Version 1.0
 */
@WebServlet("/index")
public class IndexServlet extends ViewServlet {
    BooksServiceImpl booksService= new BooksServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageIndex = req.getParameter("pageIndex");
        PageUtils<Books> booksPage = null;
        if (pageIndex==null){
            booksPage = booksService.selectAllBooksLimit(1);
        }else {
            booksPage = booksService.selectAllBooksLimit(Integer.parseInt(pageIndex));
        }
        req.setAttribute("bp",booksPage);
        processTemplate("../index",req,resp);
    }
}
