package com.llkj.dao.impl;

import com.llkj.bean.Users;
import com.llkj.dao.UsersDao;
import com.llkj.utils.DbutilsTools;

import java.sql.*;

/**
 * @ClassName UsersDaoImpl
 * @Description TODO
 * @Author qing
 * @Date 2022/11/5 10:26
 * @Version 1.0
 */
public class UsersDaoImpl extends DbutilsTools implements UsersDao {

    @Override
    public Users login(String name, String password) {
        PreparedStatement ps=null;
        Connection con=null;
        ResultSet rs=null;
        Users users=null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:13306/bookstore?characterEncoding=utf-8&serverTimezone=UTC";
            con = DriverManager.getConnection(url, "root", "123456");
            String selectUsersOne = "select * from users where username=? and password=?";
            ps = con.prepareStatement(selectUsersOne);
            ps.setString(1,name);
            ps.setString(2,password);
            rs = ps.executeQuery();
            //由于结果有一行，这里使用if或while都可以
            if (rs.next()){
                users = new Users();
                users.setId(rs.getInt(1));
                users.setUsername(rs.getString(2));
                users.setPassword(rs.getString(3));
                users.setEmail(rs.getString(4));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                ps.close();
                con.close();
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return users;
    }

    @Override
    public int register(String name, String password, String email) {
        String sql="select id from users where username=?";
        String createUser = "insert into users(username,password,email) values(?,?,?)";
        Object bean = getBean(Users.class, sql, name);
        int update=0;
        if (bean==null){
             update = update(createUser, name, password, email);
             return update;
        }
        return update;
    }
}
