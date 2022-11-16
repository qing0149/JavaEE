package com.llkj.dao;

import com.llkj.bean.Users;

/**
 * @ClassName UsersDao
 * @Description TODO
 * @Author qing
 * @Date 2022/11/5 10:25
 * @Version 1.0
 */
public interface UsersDao {
    Users login(String name, String password);
    int register(String name,String password,String email);
    Users findUserByName(String name);
}
