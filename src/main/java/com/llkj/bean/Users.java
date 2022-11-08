package com.llkj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Users
 * @Description TODO
 * @Author qing
 * @Date 2022/11/5 10:24
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private Integer id;
    private String username;
    private String password;
    private String email;
}
