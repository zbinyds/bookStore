package com.callbin.bookstores.dao.impl;

import com.callbin.bookstores.dao.UserDAO;
import com.callbin.bookstores.pojo.User;

/**
 * @author 张滨
 * @time 2022/07/12 15:06
 */
public class UserDAOImpl extends BasicDAO implements UserDAO {
    @Override
    public User getUser(String uname, String pwd) {
        return (User)querySingle("select * from t_user where uname = ? and pwd = ?", User.class, uname, pwd);
    }

    @Override
    public User getUserById(Integer userId) {
        return (User)querySingle("select * from t_user where id = ?",User.class,userId);
    }

    @Override
    public void addUser(User user) {
        update("insert into t_user values(0,?,?,?,0)",user.getUname(),user.getPwd(),user.getEmail());
    }
}
