package com.lagou.demo03.test;

import com.lagou.demo03.bean.User;
import com.lagou.demo03.dao.UserDao;
import com.lagou.demo03.dao.UserDaoImp;
import com.lagou.demo03.service.UserService;

public class UserServiceTest {

    public static void main(String[] args) {

        UserDao userDao = new UserDaoImp();
        UserService userService = new UserService();
        User admin = userService.userLoginService(new User("admin", "1234566"));
        System.out.println("找到的数据为：" + admin);
    }
}
