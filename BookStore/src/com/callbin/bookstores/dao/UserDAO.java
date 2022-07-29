package com.callbin.bookstores.dao;

import com.callbin.bookstores.pojo.User;

/**
 * @author 张滨
 * @time 2022/07/12 15:05
 */
public interface UserDAO {
    // 根据用户名、密码，获取用户
    User getUser(String uname, String pwd);

    // 根据id获取用户
    User getUserById(Integer userId);

    // 根据用户名、密码、邮箱新增一个用户
    void addUser(User user);
}
