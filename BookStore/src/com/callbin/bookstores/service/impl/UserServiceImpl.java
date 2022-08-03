package com.callbin.bookstores.service.impl;

import com.callbin.bookstores.dao.UserDAO;
import com.callbin.bookstores.pojo.User;
import com.callbin.bookstores.service.UserService;

/**
 * @author 张滨
 * @time 2022/07/12 15:13
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Override
    public User login(String uname, String pwd) {
        return userDAO.getUser(uname, pwd);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDAO.getUserById(userId);
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }
}
