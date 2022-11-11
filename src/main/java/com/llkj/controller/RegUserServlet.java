package com.llkj.controller;

import com.llkj.dao.impl.UsersDaoImpl;
import com.llkj.utils.MD5Util;
import com.llkj.utils.ViewServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName RegUserServlet
 * @Description TODO
 * @Author qing
 * @Date 2022/11/5 11:21
 * @Version 1.0
 */
@WebServlet(value = "/reguser")
public class RegUserServlet  extends ViewServlet {
    UsersDaoImpl usersDaoImpl=new UsersDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String upass = req.getParameter("upass");
        String email = req.getParameter("email");
        String encode = MD5Util.encode(upass);
        int register = usersDaoImpl.register(uname, encode, email);
        if (register>0) {
//            resp.sendRedirect("/pages/user/regist_success.html");
            processTemplate("user/regist_success",req,resp);
        }else {
            PrintWriter pw = resp.getWriter();
            pw.write("" +
                    "<script type='text/javascript'>" +
                    "alert('用户名重复请切换一个')" +
                    "location.href='regist.html'"+
                    "</script>");
            pw.close();
        }
    }
}
