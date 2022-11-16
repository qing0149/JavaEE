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
public class RegUserServlet extends ViewServlet {
    UsersDaoImpl usersDaoImpl = new UsersDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String upass = req.getParameter("upass");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        String sessionKey = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        if (code.equals(sessionKey)) {
            String encode = MD5Util.encode(upass);
            int register = usersDaoImpl.register(uname, encode, email);
            if (register > 0) {
//            resp.sendRedirect("/pages/user/regist_success.html");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write(
                        "<script type='text/javascript'>" +
                                "alert('注册成功返回登陆页面')" +
                                "location.href='/pages/user/tologin'" +
                                "</script>"
                );
                processTemplate("user/login", req, resp);
            } else {
                PrintWriter pw = resp.getWriter();
                pw.write("" +
                        "<script type='text/javascript'>" +
                        "alert('用户名重复请切换一个')" +
                        "location.href='regist.html'" +
                        "</script>");
                pw.close();
            }
        } else {
            req.setAttribute("codeerr", "验证码不正确，注册失败");
            processTemplate("user/regist", req, resp);
        }
    }
}
