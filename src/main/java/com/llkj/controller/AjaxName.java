package com.llkj.controller;

import com.llkj.service.UserService;
import com.llkj.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AjaxName
 * @Description TODO
 * @Author qing
 * @Date 2022/11/13 16:13
 * @Version 1.0
 */
@WebServlet("/ajaxusername")
public class AjaxName extends HttpServlet {
    UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        resp.setContentType("text/html;charset=utf-8");
        if(!userService.findUserIfExist(uname)){
            resp.getWriter().write("√");
        }else {
            resp.getWriter().write("用户名重复，从新更换一个");
        }
    }
}
