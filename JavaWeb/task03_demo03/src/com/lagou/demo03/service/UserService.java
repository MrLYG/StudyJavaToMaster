package com.lagou.demo03.service;

import com.lagou.demo03.bean.User;
import com.lagou.demo03.dao.UserDao;
import com.lagou.demo03.factory.UserDaoFactory;

public class UserService {
    private UserDao userDao;

    public UserService() {
        this.userDao = UserDaoFactory.getUserDao();
    }
    /**
     * 自定义成员方法实现根据参数指定的User对象来调用DAO层实现登录功能
     * @param user
     * @return
     */
    public User userLoginService(User user) {
        return userDao.userLogin(user);
    }
}
