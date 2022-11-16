package com.llkj.controller;

import com.llkj.bean.Users;
import com.llkj.dao.impl.UsersDaoImpl;
import com.llkj.utils.MD5Util;
import com.llkj.utils.ViewServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName LoginServlet
 * @Description TODO
 * @Author qing
 * @Date 2022/11/4 11:20
 * @Version 1.0
 */
//@WebServlet("/tologin")
public class LoginServlet extends ViewServlet {
    /*
    HttpServletRequest 表示请求
    HttpServletResponse 表示响应
    如何处理类和请求之间的关系
    Strin name=HttpServletRequest对象名.getParameter("表单元素的name值")
    HttpServletResponse对象名.sendRedirect("跳转到登陆此页面")
    在tomcat上http port上可以使用80端口默认隐藏
     */
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        super.service(req, resp);
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        if (username.equals("admin")&&password.equals("123456")){
//            resp.sendRedirect("/pages/user/login_success");
//        }
//        System.out.println("用户名"+username+"密码:"+password);
//        System.out.println("LoginServlet被执行了");
//    }
    UsersDaoImpl usersDaoImpl = new UsersDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String)session.getAttribute("username");
        String password = (String)session.getAttribute("password");
//        String users = (String)session.getAttribute("users");

        Users login = usersDaoImpl.login(username, password);
        if (login!=null){
            processTemplate("user/login_success", req, resp);
        }else {
            processTemplate("user/login", req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        request请求单次请求
        session存储服务器端口，是多次请求，默认设置时间半小时，
         */
        System.out.println("dopost");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String encode = MD5Util.encode(password);
        HttpSession session = req.getSession();
        Users users = usersDaoImpl.login(username, encode);
        if (users != null) {
            session.setAttribute("users",users);
            processTemplate("user/login_success", req, resp);
        } else {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter pw = resp.getWriter();
            pw.write("<script type='text/javascript'>" +
                    "alert('登录失败，用户名密码错误');" +
                    "location.href='login.html'" +
                    "</script>");
            pw.close();
        }
    }
}
