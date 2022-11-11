package com.llkj.controller;

import com.llkj.bean.Books;
import com.llkj.service.impl.BooksServiceImpl;
import com.llkj.utils.ViewServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName BookUpdateServlet
 * @Description TODO
 * @Author qing
 * @Date 2022/11/9 8:51
 * @Version 1.0
 */
@WebServlet("/updateBook")
public class BookUpdateServlet extends ViewServlet {
    BooksServiceImpl booksService=new BooksServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Books book = booksService.selectBookById(Integer.valueOf(id));
        System.out.println(book);
        req.setAttribute("book",book);
        processTemplate("manager/book_update",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String price = req.getParameter("price");
        String sales = req.getParameter("sales");
        String stock = req.getParameter("stock");
        Integer integer = booksService.UpdateBookById(id, title, author, price, sales, stock);
        System.out.println(integer);
        if (integer==1){
            resp.sendRedirect("/allBooks");
        }else {
//            resp.sendRedirect("/allBooks");
            PrintWriter pw = resp.getWriter();
            pw.write("<script type='text/javascript'>" +
                    "alert('修改失败');" +
                    "location.href='login.html'" +
                    "</script>");
            pw.close();

        }
    }
}
