package com.llkj.dao;

import com.llkj.bean.Orders;

import java.util.Date;
import java.util.List;

/**
 * @ClassName Orders
 * @Description TODO
 * @Author qing
 * @Date 2022/11/11 14:35
 * @Version 1.0
 */
public interface OrdersDao {
    //增
    Integer createOrders(Integer userId,Date orderTime,Integer totalCount,Double totalAmount,Integer state);
    // 删
    Integer deleteOrders(Integer userId,Integer id);
    // 改
    Integer updateOrders(Integer id,Integer userId,Date orderTime,Integer totalCount,Double totalAmount,Integer state);
    // 查
    Orders queryOrders(Integer id);
    List<Orders> queryAllOrdersByUserId(Integer userId);
}
