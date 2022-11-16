package com.llkj.controller;

import com.llkj.utils.ViewServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName LogOutServlet
 * @Description TODO
 * @Author qing
 * @Date 2022/11/13 0:47
 * @Version 1.0
 */
@WebServlet(value = "/loginOut")
public class LogOutServlet extends ViewServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/index");
    }
}
