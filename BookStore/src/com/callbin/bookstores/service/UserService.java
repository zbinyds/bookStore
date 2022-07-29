package com.callbin.bookstores.service;

import com.callbin.bookstores.pojo.User;

/**
 * @author 张滨
 * @time 2022/07/12 15:12
 */
public interface UserService {
    // 登录校验
    User login(String uname,String pwd);

    // 根据用户id获取到此用户信息
    User getUserById(Integer userId);

    // 注册用户
    void addUser(User user);
}
