package com.llkj.dao.impl;

import com.llkj.bean.Orders;
import com.llkj.dao.OrdersDao;
import com.llkj.utils.DbutilsTools;

import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderDaoImpl
 * @Description TODO
 * @Author qing
 * @Date 2022/11/11 14:36
 * @Version 1.0
 */
public class OrderDaoImpl extends DbutilsTools<Orders> implements OrdersDao {

    @Override
    public Integer createOrders(Integer userId, Date orderTime, Integer totalCount, Double totalAmount, Integer state) {
        String sql="insert into orders(order_time,total_count,total_amount,state,userId) values(?,?,?,?,?)";
        int count = update(sql, orderTime, totalCount, totalAmount, state, userId);
        return count;
    }

    @Override
    public Integer deleteOrders(Integer userId, Integer id) {
        String sql="delete from orders where id=? and user_id=?";
        int count = update(sql, id, userId);
        return count;
    }

    @Override
    public Integer updateOrders(Integer id,Integer userId, Date orderTime, Integer totalCount, Double totalAmount, Integer state) {
        String sql="update orders set orderTime=?,total_count=?,total_amount=?,state=? where user_id=? and id=?";
        int count = update(sql, orderTime, totalCount, totalAmount, state, userId, id);
        return count;
    }

    @Override
    public Orders queryOrders(Integer id) {
        String sql="select id,order_time as ordertime,total_count as totalcount,total_amount as totalamount,state as state,user_id as userid,form orders where id = ? ";
        Orders orders = getBean(Orders.class, sql, id);
        return orders;
    }

    @Override
    public List<Orders> queryAllOrdersByUserId(Integer userId) {
        String sql="select id,order_time as ordertime,total_count as totalcount,total_amount as totalamount,state as state,user_id as userid,form orders where user_id = ?";
        List<Orders> ordersList = getList(Orders.class, sql, userId);
        return ordersList;
    }
}
