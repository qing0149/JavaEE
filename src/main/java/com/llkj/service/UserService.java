package com.llkj.service;

import com.llkj.bean.Users;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author qing
 * @Date 2022/11/5 10:37
 * @Version 1.0
 */
public interface UserService {
    Users login(String name,String password);
    int register(String name,String password,String email);
}
