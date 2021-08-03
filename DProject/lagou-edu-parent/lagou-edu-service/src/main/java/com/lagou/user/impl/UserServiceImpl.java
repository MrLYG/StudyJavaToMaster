package com.lagou.user.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.lagou.entity.User;
import com.lagou.user.UserService;
import mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 用户表(User)表服务实现类
 *
 * @author LaoSun
 * @since 2020-09-08 10:55:49
 */
@Service //暴露服务：让消费者能够找到我
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String phone, String password) {
        return userDao.login(phone, password);
    }

    @Override
    public Integer checkPhone(String phone) {
        return userDao.checkPhone(phone);
    }

    @Override
    public Integer register(String phone, String password, String nickname, String headimg) {
        return userDao.register(phone, password,nickname, headimg);
    }
}