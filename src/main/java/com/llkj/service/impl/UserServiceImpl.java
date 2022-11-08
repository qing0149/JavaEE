package com.llkj.service.impl;

import com.llkj.bean.Users;
import com.llkj.dao.impl.UsersDaoImpl;
import com.llkj.service.UserService;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author qing
 * @Date 2022/11/5 10:37
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {
    UsersDaoImpl usersDaoImpl=new UsersDaoImpl();
    @Override
    public Users login(String name, String password) {
        return usersDaoImpl.login(name,password);
    }

    @Override
    public int register(String name, String password, String email) {
        return usersDaoImpl.register(name, password, email);
    }
}
