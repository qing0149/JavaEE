package com.llkj.controller;

import com.llkj.dao.impl.UsersDaoImpl;
import com.llkj.utils.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName LoginServlet
 * @Description TODO
 * @Author qing
 * @Date 2022/11/4 11:20
 * @Version 1.0
 */
@WebServlet("/tologin")
public class LoginServlet extends HttpServlet {
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
   UsersDaoImpl usersDaoImpl= new UsersDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dopost");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String encode = MD5Util.encode(password);
        if (usersDaoImpl.login(username,encode)!=null){
            resp.sendRedirect("/pages/user/login_success.html");
        }else {

            resp.sendRedirect("/pages/user/login.html");
        }
    }
}
