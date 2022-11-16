package com.llkj.controller;

import com.llkj.bean.Books;
import com.llkj.bean.Cart;
import com.llkj.service.BooksService;
import com.llkj.service.impl.BooksServiceImpl;
import com.llkj.utils.JSONUtils;
import com.llkj.utils.ResultJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName AddBookCart
 * @Description TODO
 * @Author qing
 * @Date 2022/11/15 9:16
 * @Version 1.0
 */
@WebServlet(value = "/addBookCarb")
public class AddBookCart extends HttpServlet {
    BooksService booksService=new BooksServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultJson resultJson=null;
        try {
            //获取id
            String bid = req.getParameter("bid");
            Books books = booksService.selectBookById(Integer.parseInt(bid));
            HttpSession session = req.getSession();
            Cart mycart = (Cart)session.getAttribute("mycart");
            if (mycart==null){
                mycart=new Cart();
                session.setAttribute("mycart",mycart);
            }
            mycart.addBookToCartItem(books);
            resultJson=resultJson.ok();
            resultJson.setResultData(mycart.getTotalCount());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            resultJson = ResultJson.error();
            resultJson.setResultData(-1);
        }
        JSONUtils.writeResult(resp,resultJson);
    }
}
