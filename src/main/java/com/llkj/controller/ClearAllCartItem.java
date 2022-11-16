package com.llkj.controller;

import com.llkj.bean.Cart;
import com.llkj.utils.JSONUtils;
import com.llkj.utils.ResultJson;
import com.llkj.utils.ViewServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

/**
 * @ClassName ClearAllCartItem
 * @Description TODO
 * @Author qing
 * @Date 2022/11/15 21:07
 * @Version 1.0
 */
@WebServlet("/clearAllCartItem")
public class ClearAllCartItem extends ViewServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart mycart = (Cart)session.getAttribute("mycart");
        String bookId = req.getParameter("bookId");
        mycart.clearAllCartItem();
        ResultJson resultJson = ResultJson.ok();
        HashMap<Object, Object> resultMap = new HashMap<>();
        resultMap.put("totalAmount",mycart.getTotalAmount());//消费总金额
        resultMap.put("totalCount",mycart.getTotalCount());//购买总量
        resultMap.put("cartitemlist",mycart.getCartItemList());//购物商品的集合
        resultJson.setResultData(resultMap);
        JSONUtils.writeResult(resp,resultJson);
    }
}
